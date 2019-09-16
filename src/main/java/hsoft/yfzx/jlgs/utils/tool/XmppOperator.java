package hsoft.yfzx.jlgs.utils.tool;

import com.google.gson.Gson;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.Device;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationBigPayload;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushedNotification;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;
import org.json.JSONException;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Localpart;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * XMPP相关操作类
 */
public class XmppOperator {

    private static String XMPP_DOMAIN;
    private static String XMPP_PLUGINS_SESSION_CHECK;
    private static String XMPP_PLUGINS_SESSION_MG;
    private static XMPPTCPConnection con;
    private static String certificatePw;
    private static String certificatePath;

    //构造方法 设置APNS推送的证书和密码
    public static void setAPNS(String certificatePassword, String certificateApnsPath) {
        certificatePw = certificatePassword;
        certificatePath = certificateApnsPath;
    }

    /**
     * XMPP连接并登录
     *
     * @param xmppHost
     * @param xmppDomain
     * @param xmppPort
     * @param userName
     * @param password
     * @throws SmackException
     * @throws IOException
     * @throws XMPPException
     * @throws InterruptedException
     */
    public static void xmppLogin(String xmppHost, String xmppDomain, int xmppPort, String userName, String password, String sessioncheckPluginsUrl, String sessionmgPluginsUrl) throws SmackException, IOException, XMPPException, InterruptedException {
        XMPP_DOMAIN = xmppDomain;
        XMPP_PLUGINS_SESSION_CHECK = sessioncheckPluginsUrl;
        XMPP_PLUGINS_SESSION_MG = sessionmgPluginsUrl;
        XMPPTCPConnectionConfiguration.Builder config = XMPPTCPConnectionConfiguration.builder()
                // 端口号
                .setPort(xmppPort)
                // xmpp服务器的域
                .setXmppDomain(xmppDomain)
                // xmpp服务器地址
                .setHostAddress(InetAddress.getByName(xmppHost))
                // 用户名密码
                .setUsernameAndPassword(userName, password)
                // 登录后不接收消息
                .setSendPresence(true).setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                .setCompressionEnabled(false).setDebuggerEnabled(false);
        // xmpp连接对象
        con = new XMPPTCPConnection(config.build());

        con.setUseStreamManagement(false);
        // 建立连接
        con.connect();
        // 登录
        con.login();
    }

    /**
     * 发送单人xmpp消息
     *
     * @param rece    接收人（发给谁）
     * @param msgInfo 消息内容
     * @return true 成功/false 失败
     * @throws InterruptedException
     * @throws XMPPException
     * @throws IOException
     * @throws SmackException
     */
    public static boolean xmppSend(String rece, String msgInfo)
            throws SmackException, IOException, XMPPException, InterruptedException {

        // XMPPTCPConnection con = xmppLogin();
        // 创建
        ChatManager chatManager = ChatManager.getInstanceFor(con);
        //
        EntityBareJid entityBareJid = JidCreate.entityBareFrom(rece + "@" + XMPP_DOMAIN);
        // 建立聊天
        Chat chat = chatManager.chatWith(entityBareJid);
        // 新建消息
        Message message = new Message(entityBareJid, Message.Type.chat);
        //
        message.setBody(msgInfo);
        chat.send(message);
        return true;
    }

    /**
     * 根据用户名和密码创建xmpp账号
     *
     * @param username 用户名
     * @param password 密码
     * @return true 成功 / false 失败
     * @throws InterruptedException
     * @throws XMPPException
     * @throws IOException
     * @throws SmackException
     */
    public static boolean register(String username, String password)
            throws SmackException, IOException, XMPPException, InterruptedException {
        // 获取登录xmpp后的连接
        // XMPPTCPConnection con = xmppLogin();
        AccountManager account = AccountManager.getInstance(con);
        account.sensitiveOperationOverInsecureConnection(true);
        if (account.supportsAccountCreation()) {
            // 若支持创建用户，则根据用户名和密码创建用户
            account.createAccount(Localpart.from(username), password);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 发送APNS推送
     *
     * @param deviceTokens 设备码的列表
     * @param content      发送的内容
     * @param title        APNS推送标题
     * @param info         消息内容，一般为xmpp消息
     * @throws JSONException
     * @throws CommunicationException
     * @throws KeystoreException
     * @throws InvalidDeviceTokenFormatException
     */
    public static void sendAPNS(List<String> deviceTokens, String content, String title, String info)
            throws JSONException, CommunicationException, KeystoreException, InvalidDeviceTokenFormatException {
        // 小红圈数量
        // int badge = 1;
        // 铃声
        String sound = "default";

        List<String> tokens = new ArrayList<String>();
        tokens.addAll(deviceTokens);

        //
        boolean sendCount = true;

        PushNotificationBigPayload payload = new PushNotificationBigPayload();
        // 发送的标题
        payload.addCustomAlertTitle(title);
        // 发送的内容
        payload.addCustomAlertBody(content);
        // 设置小红圈中显示的数量
        // payload.addBadge(badge);
        // 设置提示音
        payload.addSound(sound);

        payload.addCustomDictionary("xmpp", info);

//        String host = "api.push.apple.com";
//        int port = 443;

        PushNotificationManager pushManager = new PushNotificationManager();
        // false 产品测试推送服务 true 产品发布推送服务
        pushManager
                .initializeConnection(new AppleNotificationServerBasicImpl
                        (certificatePath, certificatePw, true));

        List<PushedNotification> notifications = new ArrayList<PushedNotification>();

        // 开始推送消息
        if (sendCount) {
            for (String token : tokens) {
                Device device = new BasicDevice();
                device.setToken(token);
                PushedNotification notification = pushManager.sendNotification(device, payload, true);
                notifications.add(notification);
            }
        } else {
            List<Device> devices = new ArrayList<Device>();
            for (String token : tokens) {
                devices.add(new BasicDevice(token));
            }

            notifications = pushManager.sendNotifications(payload, devices);
        }
        List<PushedNotification> failedNotification = PushedNotification.findFailedNotifications(notifications);
        List<PushedNotification> successNotification = PushedNotification.findSuccessfulNotifications(notifications);

        int failed = failedNotification.size();
        int sucessful = successNotification.size();

        System.out.println("zsl==========成功数：" + sucessful);
        System.out.println("zsl==========失败数：" + failed);
        pushManager.stopConnection();
    }

    /**
     * 群发消息(不含APNS推送)
     *
     * @param userNameList 用户名列表
     * @param msgInfo      消息内容
     * @throws SmackException
     * @throws IOException
     * @throws XMPPException
     * @throws InterruptedException
     */
    public static void sendMultiXmpp(List<String> userNameList, String msgInfo)
            throws SmackException, IOException, XMPPException, InterruptedException {
        // 循环为群组人员发送消息
        if (userNameList != null && userNameList.size() > 0) {
            for (String userName : userNameList) {
                xmppSend(userName, msgInfo);
            }
        }
    }

    /**
     * 发送xmpp消息（带APNS推送）
     * @param userNameList 发送xmpp消息人员列表
     * @param IMEIList 发送APNS推送人员的IMEI列表
     * @param content APNS推送内容（对话框提示的内容）
     * @param title APNS推送标题
     * @param msgInfo xmpp消息体
     * @throws SmackException
     * @throws IOException
     * @throws XMPPException
     * @throws InterruptedException
     * @throws JSONException
     * @throws CommunicationException
     * @throws KeystoreException
     * @throws InvalidDeviceTokenFormatException
     */
    public static void sendXMPP(List<String> userNameList, List<String> IMEIList, String content, String title, String msgInfo)
            throws SmackException, IOException, XMPPException, InterruptedException, JSONException,
            CommunicationException, KeystoreException, InvalidDeviceTokenFormatException {
        //群发xmpp消息
        sendMultiXmpp(userNameList, msgInfo);

        //发送APNS消息
        if (IMEIList.size() > 0){
            sendAPNS(IMEIList, content, title, msgInfo);
        }
    }

    /**
     * 检查连接是否存在
     * @param userName 用户名
     * @param resource 资源名称
     * @return 1连接存在/-100连接不存在
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings({ "unchecked", "rawtypes"})
    public static String checkSession(String userName, String resource) throws UnsupportedEncodingException {
        String result = "";
        //根据传入的数据组拼jid
        String jid = userName + "@" + XMPP_DOMAIN + "/" + resource;
        //检查连接是否有效的接口地址
        String url= XMPP_PLUGINS_SESSION_CHECK;

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //组拼请求数据
        LinkedMultiValueMap<String, String> body=new LinkedMultiValueMap<String, String>();
        //FBase64加密
        jid = FBase64.encode(jid.getBytes("UTF-8"));
        body.add("value", jid);
        HttpEntity entity = new HttpEntity(body, headers);

        RestTemplate restTemplate = new RestTemplate();

        //发送请求并获取返回结果
        try{
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, (HttpEntity<String>) entity, String.class);
            result = responseEntity.getBody();
        }catch(Exception e){
            e.printStackTrace();
            result = "-200";
        }

        return result;
    }

    /**
     * 断开连接
     * @param userName 用户名
     * @param resource 资源代码
     * @return 1成功  -100连接不存在 -200断开失败
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String closeSession(String userName, String resource) throws UnsupportedEncodingException{
        String result = "";
        //根据传入的数据组拼jid
        String jid = userName + "@" + XMPP_DOMAIN + "/" + resource;
        //检查连接是否有效的接口地址
        String url=XMPP_PLUGINS_SESSION_MG;

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //组拼请求数据
        LinkedMultiValueMap<String, String> body=new LinkedMultiValueMap<String, String>();
        //FBase64加密
        jid = FBase64.encode(jid.getBytes("UTF-8"));
        body.add("value", jid);
        HttpEntity entity = new HttpEntity(body, headers);

        RestTemplate restTemplate = new RestTemplate();

        //发送请求并获取返回结果
        try{
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, (HttpEntity<String>) entity, String.class);
            result = responseEntity.getBody();
        }catch(Exception e){
            e.printStackTrace();
            result = "-200";
        }

        return result;
    }

}

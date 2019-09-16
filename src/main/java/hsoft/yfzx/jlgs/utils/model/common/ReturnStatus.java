package hsoft.yfzx.jlgs.utils.model.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ReturnStatusSerializer.class)
public enum ReturnStatus {
	OK("1", "成功"), 
	ERR0001("E0001", "输入数据校验不通过"), 
	ERR0002("E0002", "输入数据存在重复"), 
	ERR0003("E0003", "操作数据不存在"), 
	ERR0004("E0004", "操作数据库失败"),
	ERR0005("E0005", "加载失败，请稍后再试"),
	ERR0006("E0006", "XMPP服务错误"),
	ERR0007("E0007", "XMPP服务器不支持注册功能"),
	ERR0008("E0008", "APNS推送服务错误"),
	ERR0009("E0009", "token超时失效"),
	ERR0010("E0010", "token不存在"),
	ERR0011("E0011", "账号重复登录"),
	ERR0012("E0012", "当前账号无权限进行此操作"),
	ERR0013("E0013", "用户名或密码错误"),
	ERR0014("E0014", "消息服务器连接失败"),
	ERR0015("E0015", "用户名已存在"),
	ERR0016("E0016", "传入参数格式不正确"),
	ERR0017("E0017", "服务器错误"),
	ERR0018("E0018", "未按要求传入数据"),
	ERR0019("E0019", "发送人员不存在"),
	ERR0020("E0020", "接收方不存在"),
	ERR0021("E0021", "未知错误"),
    ERR0022("E0022", "机构有人员不能删除"),
    ERR0023("E0023", "机构有子机构不能删除"),
	ERR0024("E0024", "原密码有误"),
	ERR0025("E0025", "只有普通职员才能进行此操作"),
	ERR0026("E0026", "您已被移出该群组"),
	ERR0027("E0027", "该群组已被解散"),
	ERR0028("E0028", "该用户不存在"),
	ERR0029("E0029", "上传文件失败");
	
	private String code;

	private String desc;

	private ReturnStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	/**
	 * 根据代码返回枚举对象
	 * 
	 * @param code
	 * @return
	 */
	public static ReturnStatus getStatusByCode(String code) {
		if (code == null) {
			return null;
		}
		for (ReturnStatus status : ReturnStatus.values()) {
			if (status.getCode().equals(code)) {
				return status;
			}
		}
		return null;
	}
}

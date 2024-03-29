/**
 * <p>Title: FBase64.java</p>
 * <p>Package: com.hitsoftware.Android.SurviveValidationOffice.ClientToServerOperation</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: HIT Software</p>
 * @author 
 * @date 2013-9-3
 * @version 1.0
*/
package hsoft.yfzx.jlgs.utils.tool;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class FBase64 {
    private static char[] base64EncodeChars = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = new byte[]{
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
   
    public static String encode(byte[] data) {
        if(data == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        
        Random r = new Random();
        int iv = r.nextInt(64);
        sb.append(base64EncodeChars[iv]);
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[((b1 >>> 2) + iv + sb.length()) % 64]);
                sb.append(base64EncodeChars[(((b1 & 0x3) << 4) + iv + sb.length()) % 64]);
                //sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[((b1 >>> 2) + iv + sb.length()) % 64]);
                sb.append(base64EncodeChars[((((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)) + iv + sb.length()) % 64]);
                sb.append(base64EncodeChars[(((b2 & 0x0f) << 2) + iv + sb.length()) % 64]);
                //sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[((b1 >>> 2) + iv + sb.length()) % 64]);
            sb.append(base64EncodeChars[((((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)) + iv + sb.length()) % 64]);
            sb.append(base64EncodeChars[((((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)) + iv + sb.length()) % 64]);
            sb.append(base64EncodeChars[((b3 & 0x3f) + iv + sb.length()) % 64]);
        }
        return sb.toString();
    }
   
    private static byte restoreData(byte src, int iv, int pos) {
    	int r = src;
    	while (r < pos)
    		r += 64;
    	r -= pos;
    	if (r < iv)
    		r += 64;
    	r -= iv;
    	return (byte)(r & 0xff);
    }
    
    public static byte[] decode(String str) throws UnsupportedEncodingException {
        if(str == null){
            return "".getBytes();
        }
        byte[] data = str.getBytes("US-ASCII");
        int len = data.length;
        if ((len % 4) == 2)
        	return null;
        StringBuffer sb = new StringBuffer();
        int iv = base64DecodeChars[data[0]];
        if (iv == -1)
        	return null;
        int i = 1;
        int b1, b2, b3, b4;
        while (i < len) {
           
            do {
                b1 = restoreData(base64DecodeChars[data[i]], iv, i);
                i++;
            } while (i < len && b1 == -1);
            if (b1 == -1) break;
           
            do {
                b2 = restoreData(base64DecodeChars[data[i]], iv, i);
                i++;
            } while (i < len && b2 == -1);
            if (b2 == -1) break;
            sb.append((char) ((b1 << 2) | ((b2 & 0x30) >>> 4)));
           
            if (i == len) break;
            do {
            	b3 = restoreData(base64DecodeChars[data[i]], iv, i);
//                if (b3 == 61) return sb.toString().getBytes("iso8859-1");
                i++;
            } while (i < len && b3 == -1);
            if (b3 == -1) break;
            sb.append((char) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));
           
            if (i == len)
            	break;
            do {
                b4 = restoreData(base64DecodeChars[data[i]], iv, i);
                //if (b4 == 61) return sb.toString().getBytes("iso8859-1");
                i++;
            } while (i < len && b4 == -1);
            if (b4 == -1) break;
            sb.append((char) (((b3 & 0x03) << 6) | b4));
        }
		return sb.toString().getBytes("iso8859-1");
	}
}

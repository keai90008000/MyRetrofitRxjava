package myss.baway.com.myretrofitrxjava.utils;

import java.security.MessageDigest;

/**
 * 类用途：
 * 姓名： 谢岳峰
 * 日期： 2017/5/24 16:41
 */

public class MD5Utils {
    public static String getMD5(String val)  {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = val.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int vali = ((int) md5Bytes[i]) & 0xff;
            if (vali < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(vali));
        }
        return hexValue.toString().toUpperCase();//32位
//        return buf.toString().substring(8, 24);   //16位
    }
}

package cn.likole.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by likole on 4/21/2017.
 */
public class MD5Util {
    public static String MD5Encode(String plain) {
        MessageDigest md5= null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bytes=md5.digest(plain.getBytes());
        StringBuffer stringBuffer=new StringBuffer("");
        for (int i=0;i<bytes.length;i++){
            int tmp=bytes[i];
            if(tmp<0)tmp+=256;
            if(tmp<16) stringBuffer.append("0");
            stringBuffer.append(Integer.toHexString(tmp));
        }
        return stringBuffer.toString();
    }
}

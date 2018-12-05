package com.lc.util;

import java.security.MessageDigest;

/**
 * Created by lenovo on 2018/12/3.
 */
public class MD5Util {

    private static String charset = "UTF-8";

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     *
     * @param origin
     * @param charsetname  null则使用默认utf-8编码
     * @return
     */
    public static String string2MD5(String origin, String charsetname) {
        if(charsetname==null)
            charsetname=charset;
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                                                                      .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                                                                      .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
                                                "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}

package com.smt.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLUtil {

    public static String urlDecode(String str ) {
        String decode = "";
        try {
            decode = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decode;
    }

}

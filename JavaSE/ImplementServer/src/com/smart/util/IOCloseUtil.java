package com.smart.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Smart-T
 * 关闭流
 *
 */
public class IOCloseUtil {
    public static void closeAll(Closeable...closeables){
        for (Closeable close : closeables){
            try {
                if (close != null) close.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

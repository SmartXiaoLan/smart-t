package com.smt.util;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author Smart-T
 *
 *
 */
public class StreamCloseUtil {

    /**
     * 批量关闭流
     * @param closeables
     */
    public static void closeAll(Closeable ... closeables){
        for(Closeable close:closeables){
            try {
                if (close != null) close.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

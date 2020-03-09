package cn.smart;

import com.jfinal.core.JFinal;

/**
 * @author Smart-T
 *
 * 独立的启动类
 *
 */
public class ApplicationStart {
    public static void main(String[] args) {
        JFinal.start("src/main/webapp" , 80 , "/" , 5);
    }
}

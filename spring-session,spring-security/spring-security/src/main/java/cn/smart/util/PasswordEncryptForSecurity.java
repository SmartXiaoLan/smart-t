package cn.smart.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Smart-T
 *
 * 添加用户的密码编码工具
 *
 * 说明：
 *      BCryptPasswordEncoder方法采用SHA-256 +随机盐+密钥对密码进行加密。
 *      SHA系列是Hash算法，不是加密算法，使用加密算法意味着可以解密（这个与编码/解码一样），、
 *      但是采用Hash处理，其过程是不可逆的。
 *
 */
public class PasswordEncryptForSecurity {

    private static   final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 获取BCryptPasswordEncoder加密后的字符串
     * @param str
     * @return
     */
    public static String getEncodeStr(String str){
        return encoder.encode(str);
    }

    /**
     * 验证加密
     * @param str 明文字符串
     * @param encodeStr 加密后的字符串
     * @return
     */
    public static boolean validPassword(String str,String encodeStr){
        return encoder.matches(str,encodeStr);
    }

}

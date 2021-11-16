package com.lc.security.oauth.utils;

/**
 * 短信工具类
 *
 * @author luchao
 * @date 2021/11/16
 */
public class SmsUtil {

    /**
     * 生成短信验证码
     * <p>
     *  一般由第三方短信服务（阿里云等）提供
     * </p>
     *
     * @return 短信验证码
     */
    public static String createSmsCode() {
        return "445566";
    }

    /**
     * 校验
     *
     * @param mobile 手机号
     * @param code 验证码
     */
    public static void check(String mobile, String code) {

    }
}

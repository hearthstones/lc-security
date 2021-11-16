package com.lc.security.oauth.constants;

/**
 * 正则表达式常量类
 *
 * @author luchao
 * @date 2021/11/16
 */
public class RegexpConst {

    /**
     * 手机号格式
     */
    public final static String MOBILE_REG = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";

    /**
     * 手机验证码格式
     */
    public final static String MOBILE_CODE_REG = "^\\d{6}$";

}

package com.lc.security.oauth.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 短信工具类
 *
 * @author luchao
 * @date 2021/11/16
 */
@Slf4j
@Component
public class SmsUtil {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 短信验证码 key 前缀
     */
    private final String SMS_CODE_KEY_PRE = "oauth:sms:code:auth:";


    /**
     * 发送短信验证码
     * <p>
     *  一般由第三方短信服务（阿里云等）提供
     * </p>
     *
     * @return 短信验证码
     */
    public String sendCode(String mobile) {
        // 生成短信验证码
        String code = String.valueOf((int)((Math.random() * 9 + 1) * Math.pow(10, 5)));
        // 存入redis
        redisTemplate.opsForValue().set(SMS_CODE_KEY_PRE + mobile, code, 60, TimeUnit.SECONDS);
        log.info("手机验证码已发送！mobile: {}, code: {}", mobile, code);
        return code;
    }

    /**
     * 校验
     *
     * @param mobile 手机号
     * @param code 验证码
     */
    public void check(String mobile, String code) {
        String key = SMS_CODE_KEY_PRE + mobile;
        if (!ObjectUtils.defaultIfNull(redisTemplate.hasKey(key), false)) {
            log.error("验证码未发送");
        }
        Long expire = redisTemplate.getExpire(key);
        if (expire != null && expire < 0) {
            log.error("验证码已过期");
        }
        if (!StringUtils.equals(redisTemplate.opsForValue().get(key), code)) {
            log.error("验证码不匹配");
        }
        // 校验成功，删除验证码
        redisTemplate.delete(key);
    }
}

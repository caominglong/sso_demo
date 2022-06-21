package com.banmao.demo.controller.base;

import javax.servlet.http.HttpSession;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description:
 * @author: banmao
 * @date: 2022/6/21 17:11
 */
public class WebUtils {

    public static boolean validateCaptcha(String inputCaptcha, String redisKeyPrefix, HttpSession session) {
        String uuid = (String) session.getAttribute("uuid");
        String key = redisKeyPrefix + uuid;
        return true;
    }
}

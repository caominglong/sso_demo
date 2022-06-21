package com.banmao.demo.controller;

import com.banmao.demo.controller.base.Result;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description:
 * @author: banmao
 * @date: 2022/6/21 14:14
 */
public class LoginController {

    @GetMapping("/login")
    public Result login(String username, String password, String inputCaptcha, HttpSession session, HttpServletResponse response) {
        // 判断验证码是否正确

        // CookieUtil.getCookieValueByName()
        return Result.success();
    }
}

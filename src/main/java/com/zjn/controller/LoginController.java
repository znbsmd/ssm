package com.zjn.controller;

import com.zjn.utils.CookieUtil;
import com.zjn.utils.JavaWebToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(HttpSession session, @RequestParam String account, @RequestParam String password, RedirectAttributes model){

        if("zjn".equals(account) && "123321".equals(password)){
//            Map<String,Object> loginInfo = new HashMap<>();

            session.setAttribute("isLogin","true");
            session.setAttribute("time",new Date());

            return "redirect:loginSuccess";
        }else{
            model.addFlashAttribute("error", "false");
            return "redirect:login";
        }
    }
    @RequestMapping(value = "/loginSuccess", method = {RequestMethod.GET})
    public String accusationPage(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping(value = "/logOut", method = {RequestMethod.GET})
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(response,"isLogin");
        return "redirect:loginPage";
    }

    @RequestMapping(value = "/loginPage", method = {RequestMethod.GET})
    public String loginPage() {
        return "login";
    }

}

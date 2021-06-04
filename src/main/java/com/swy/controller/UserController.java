package com.swy.controller;

import com.swy.service.MailService;
import com.swy.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    public MailService mailService;

    @PostMapping("/sendEmail")
    public String sendEmail(String email, HttpSession httpSession, Model model) {

        if (mailService.sendMimeMail(email, httpSession)) {
            return "redirect:/register.html";
        }else {
            //告诉用户登录失败了！
            model.addAttribute("msg", "发送失败请检查网络或者邮箱格式是否正确");
            return "sendEmail.html";
        }


    }

    @PostMapping("/regist")
    public String regist(UserVo userVo, HttpSession session, Model model) {
        if (mailService.registered(userVo, session)) {
            return "redirect:/login.html";
        } else {
            model.addAttribute("msg","验证码错误");
            return "register.html";
        }


    }

    @PostMapping("/login")
    public String login(String email, String password, Model model) {

        //具体业务：
        if (mailService.loginIn(email, password)) {
            return "redirect:/dashboard.html";
        } else {
            //告诉用户登录失败了！
            model.addAttribute("msg", "用户名或者密码错误");
            return "login.html";
        }


//        return "redirect:/dashboard.html";
    }
}
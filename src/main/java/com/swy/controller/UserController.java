package com.swy.controller;

import com.swy.mapper.UserMapper;
import com.swy.pojo.Page;
import com.swy.pojo.User;
import com.swy.service.MailService;
import com.swy.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    public MailService mailService;

    @Autowired
    public UserMapper userMapper;


    /**
     * 发送邮箱
     * @param email
     * @param httpSession
     * @param model
     * @return
     */
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

    /**
     * 注册
     * @param userVo
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/regist")
    public String regist(UserVo userVo, HttpSession session, Model model) {
        if (mailService.registered(userVo, session)) {
            return "redirect:/login.html";
        } else {
            model.addAttribute("msg","验证码错误");
            return "register.html";
        }
    }

    /**
     * 登录
     * @param email
     * @param password
     * @param model
     * @return
     */
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

    /**
     * 添加一个用户
     * @param AddUsername
     * @param AddEmail
     * @param AddPassword
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(@RequestParam("AddUsername") String AddUsername,
                          @RequestParam("AddEmail") String AddEmail,
                          @RequestParam("AddPassword") String AddPassword){

        log.info("AddUsername:{}",AddUsername);
        log.info("password:{}",AddPassword);
        log.info("email:{}",AddEmail);

        userMapper.AddUser(AddUsername,AddEmail,AddPassword);
        return "redirect:/tables";
    }

    /**
     * 修改一个用户
     * @param upUsername
     * @param upEmail
     * @param upPassword
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("upUsername") String upUsername,
                             @RequestParam("upEmail") String upEmail,
                             @RequestParam("upPassword") String upPassword){
        log.info("AddUsername:{}",upUsername);
        log.info("password:{}",upPassword);
        log.info("email:{}",upEmail);

        userMapper.updateUser(upUsername,upEmail,upPassword);
        return "redirect:/tables";
    }

    /**
     * 显示所有信息
     * @param model
     * @return
     */
    @GetMapping( "/tables")
    public String selectAll(Model model){
        List<User> list = userMapper.selectAll();
        model.addAttribute("infos",list);
        return "tables.html";
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteInfo/{id}", method = RequestMethod.GET)
    public String deleteInfo(@PathVariable("id")int id){
        userMapper.deleteInfo(id);
        return "redirect:/tables";
    }

    /**
     * 上传信息
     * @param user
     * @param email
     * @param titles
     * @param pages
     * @return
     */
    @PostMapping("/addText")
    public String addText(@RequestParam("user") String user,
                          @RequestParam("email") String email,
                          @RequestParam("titles") String titles,
                          @RequestParam("pages") String pages){
        log.info("AddUsername:{}",user);
        log.info("password:{}",email);
        log.info("email:{}",titles);

        userMapper.addText(user,email,titles,pages);
        return "redirect:/find.html";
    }

    @GetMapping( "/Mc")
    public String ShowInfo(Model model){
        List<Page> list = userMapper.showInfo();
        model.addAttribute("infos",list);
        return "Mc";
    }

    @GetMapping( "/McM")
    public String ShowInfoMeg(Model model){
        List<Page> list = userMapper.showInfo();
        model.addAttribute("infos",list);
        return "McM";
    }

    @RequestMapping(value = "/deleteMc/{id}", method = RequestMethod.GET)
    public String deleteMc(@PathVariable("id")int id){
        userMapper.deleteMc(id);
        return "redirect:/McM";
    }
}

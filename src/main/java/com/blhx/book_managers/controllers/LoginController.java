package com.blhx.book_managers.controllers;

import com.blhx.book_managers.biz.LoginBiz;
import com.blhx.book_managers.model.User;
import com.blhx.book_managers.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginBiz loginBiz;
    @Autowired

    @GetMapping("/users/register")
    public String register(){
        return "login/register";
    }
    @RequestMapping(path = {"/users/register/do"}, method = {RequestMethod.POST})
    public String doRegister(@RequestParam("email") String email
            , @RequestParam("password") String password
            , @RequestParam("name") String name
            , HttpServletResponse response, Model model ){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        try {
            String t=loginBiz.register(user);
            CookieUtils.writeCookie("t",t,response);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            return "404";
        }

    }
    @GetMapping("/users/login")
    public String login(){
        return "login/login";
    }
    @RequestMapping(path = {"/users/login/do"}, method = {RequestMethod.POST})
    public   String dologin( @RequestParam("email") String email
                            , @RequestParam("password") String password
                            , HttpServletResponse response, Model model ){

        try {
            String t=loginBiz.login(email, password);
            CookieUtils.writeCookie("t",t,response);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            return "404";
        }
    }
    @GetMapping("/users/logout/do")
    public String logout(@CookieValue("t") String t){
        loginBiz.logout(t);
        return "redirect:/index";
    }
}

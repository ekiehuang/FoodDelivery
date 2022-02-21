package com.southwind.controller;

import com.southwind.entity.Admin;
import com.southwind.entity.User;
import com.southwind.feign.AccountFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type,
                        HttpSession session) {
        Object object = accountFeign.login(username, password, type);
        LinkedHashMap<String, Object> map = (LinkedHashMap)object;
        String result = null;
        if (object == null) {
            result = "login";
        } else {
            switch (type) {
                case "user":
                    User user = new User();
                    String idStr = map.get("id").toString(); //尽管value是object，但是具体是Integer,用cast转换会失败，可以用toString()
                    long id = Long.parseLong(idStr);
                    String nickname = map.get("nickname").toString();
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user", user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    String adminIdStr = map.get("id").toString();
                    long adminId = Long.parseLong(adminIdStr);
                    String adminName = (String) map.get("username");
                    admin.setId(adminId);
                    admin.setUsername(adminName);
                    session.setAttribute("admin", admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }
}

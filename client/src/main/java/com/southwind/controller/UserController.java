package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.feign.UserFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return userFeign.findAll(index, limit);
//        UserVO userVO = new UserVO();
//        userVO.setCode(0);
//        userVO.setMsg("");
//        userVO.setCount(userFeign.count());
//        userVO.setData(userFeign.findAll(index, limit));
//        return userVO;
    }


    @GetMapping("/count")
    public int count() {
        return userFeign.count();
    }

    @PostMapping("/save")
    public String save(User user) { //这里不能加@RequestBody注解，因为前端是普通传参方式（从user_add.html文档可以看出）
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/menu/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        userFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage";
    }
}

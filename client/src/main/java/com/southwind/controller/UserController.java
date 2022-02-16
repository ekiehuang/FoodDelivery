package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.feign.UserFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserFeign userFeign;

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit")int limit) {
        return userFeign.findAll(index, limit);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id) {
        return userFeign.findById(id);
    }

    @GetMapping("/count")
    public int count() {
        return userFeign.count();
    }

    @PostMapping("/save")
    public void save(User user) {
        userFeign.save(user);
    }

    @PutMapping("/update")
    public void update(User user) {
        userFeign.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userFeign.deleteById(id);
    }
}

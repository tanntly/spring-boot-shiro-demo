package cn.tanntly.webapp.module.controller;

import cn.tanntly.dao.UserRepository;
import cn.tanntly.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/test")
    @ResponseBody
    public User login(String userName,String password){

        User user = userRepository.findByUserNameAndPassword(userName,password);
        return user;

    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @GetMapping(value = "/error1")
    public String error(){
        return "error ok!";
    }

    //注解的使用
//    @RequiresRoles("user")
//    @RequiresPermissions("p1")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }
}

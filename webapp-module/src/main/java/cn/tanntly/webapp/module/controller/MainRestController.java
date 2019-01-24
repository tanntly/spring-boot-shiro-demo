package cn.tanntly.webapp.module.controller;

import cn.tanntly.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @PostMapping(value = "/login")
    public String login(@RequestBody User user){

        System.out.println("==="+user);

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(),user.getPassword());

        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);

        return "success";

    }

}

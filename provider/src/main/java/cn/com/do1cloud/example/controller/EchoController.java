package cn.com.do1cloud.example.controller;

import cn.com.do1cloud.example.api.User;
import cn.com.do1cloud.example.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zengxc
 * @since 2020/11/10
 */
@RestController
@RefreshScope
public class EchoController {
    @Value("${user.name}")
    private String userName;
    @Value("${user.age}")
    private Integer age;
    @Value("${app.version}")
    private String version;
    @DubboReference
    private UserService userService;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return userName + "(" + age + ") say: hello " + string + "</br>from app:" + version;
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable Integer id) {
        return userService.findById(id);
    }
}


package cn.com.do1cloud.example.service;

import cn.com.do1cloud.example.api.User;
import cn.com.do1cloud.example.api.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public User findById(int id) {

        return new User("zengxc",18);
    }
}

package com.baizhi.feign;

import com.baizhi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HelloFeignImpl implements HelloFeign{
    @Override
    public User hello(User user) {
        User user1 = new User("error", 0, "1");
        return user1;
    }
}

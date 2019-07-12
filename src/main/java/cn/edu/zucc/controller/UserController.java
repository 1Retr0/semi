package cn.edu.zucc.controller;

import cn.edu.zucc.common.R;
import cn.edu.zucc.domain.entity.User;
import cn.edu.zucc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    UserService userservice;

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public R<User> getUser(@PathVariable String name) {
        return R.data(userservice.getUser(name));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public R<String> register(@RequestBody @Valid User user) {
        userservice.create(user);
        return R.success("success");
    }

    @RequestMapping(value = "/superior/{name}", method = RequestMethod.GET) //查看开发人员所属的承包商
    public R<List<User>> getDeveloper(@PathVariable String name) {
        return R.data(userservice.getDeveloper(name));
    }
}

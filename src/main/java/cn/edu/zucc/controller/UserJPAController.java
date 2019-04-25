package cn.edu.zucc.controller;

import cn.edu.zucc.Annotation.PassToken;
import cn.edu.zucc.Annotation.Role;
import cn.edu.zucc.Annotation.UserLoginToken;
import cn.edu.zucc.common.*;
import cn.edu.zucc.domain.entity.User;
import cn.edu.zucc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserJPAController {

    @Autowired
    UserService service;

    /**
     * 用户列表
     */
    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/", method = RequestMethod.GET)
    public R<List<User>> getUserList() {
        System.out.println("a");
        return R.data(service.getAllUsers());
    }

    /**
     * 用户列表
     */
    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/", method = RequestMethod.POST)
    public R<String> postUser(@Valid @ModelAttribute User user) {
        /*if(StringUtils.isEmpty(user.getName())) {
            throw new NullPointerException("用户名不能为空");
        } */
        user.setSalt(HashKit.generateSalt(8));
        user.setPassword(HashKit.md5(user.getPassword()+user.getSalt()));
        service.create(user);
        return R.success("success");
    }

    /*@RequestMapping(value="/", method = RequestMethod.GET)
    public R<List<User>> getUserList() {
        return R.data(service.getAllUsers());
    }


    @RequestMapping(value="/", method = RequestMethod.POST)
    public R<String> postUser(@ModelAttribute User user) {
        service.create(user);
        return R.success("success");
    } */

    /**
     * 用户列表
     */
    @Role("admin")
    @PassToken
    @RequestMapping(value="/Login", method = RequestMethod.POST)
    public R<String> loginUser(@RequestParam String name, @RequestParam String password) {
        User user=service.getUser(name, password);
        return user == null?R.fail("用户不存在或密码错误"):R.Loginsuccess(user);
//        User user=service.getUser(name);
//        if(user == null ) {
//            return R.fail("用户不存在");
//        }
//
//        return user.getPassword().equals(HashKit.md5(password+user.getSalt()))?R.Loginsuccess(user):R.fail("密码错误");
    }

    @UserLoginToken
    @RequestMapping(value="/password", method = RequestMethod.PUT)
    public R<String> modPassword(@RequestParam String name, @RequestParam String password, @RequestParam String password2) {
        User user = service.getUser(name);
        if (user == null) {
            return R.fail("请先登录用户");
        }
        if (!password.equals(password2)) {
            return R.fail("两次输入的密码不同");
        }
        user.setPassword(HashKit.md5(password+user.getSalt()));
        service.update(user);
        return R.success("success");
    }

    /**
     * 用户列表
     */
    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public R<User> getUser(@PathVariable Long id) {
        //return R.data(service.getUser(id));
        return R.data(service.getUser(id));
    }

    /**
     * 用户列表
     */
    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public R<String> putUser(@PathVariable Long id, @ModelAttribute User user) {
        //service.update(id, user.getName(), user.getAge());
        user.setId(id);
        service.update(user);
        return R.success("success");
    }

    /**
     * 用户列表
     */
    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public R<String> deleteUser(@PathVariable Long id) {
        service.deleteById(id);
        return R.success("success");
    }

//    @RequestMapping(value="/query", method = RequestMethod.GET)
//    public R<User> getUser(@RequestParam String name) {
//        return R.data(service.findUser(name));
//    }
}

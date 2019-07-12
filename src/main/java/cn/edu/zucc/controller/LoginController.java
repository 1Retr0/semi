package cn.edu.zucc.controller;

import cn.edu.zucc.Annotation.PassToken;
import cn.edu.zucc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserService service;


    @PassToken
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login() { return "login"; }

    @PassToken
    @RequestMapping(value="/publish",method= RequestMethod.GET)
    public String publish()
    {
        return "publish";
    }

    @PassToken
    @RequestMapping(value="/contract",method= RequestMethod.GET)
    public String contract()
    {
        return "contract";
    }

    @PassToken
    @RequestMapping(value="/accept",method= RequestMethod.GET)
    public String accept()
    {
        return "accept";
    }

    @PassToken
    @RequestMapping(value="/projectDetail",method= RequestMethod.GET)
    public String publishDetail()
    {
        return "projectDetail";
    }

    @PassToken
    @RequestMapping(value="/aDetail",method= RequestMethod.GET)
    public String aDetail()
    {
        return "aDetail";
    }

    @PassToken
    @RequestMapping(value="/tDetail",method= RequestMethod.GET)
    public String tDetail()
    {
        return "tDetail";
    }


    @PassToken
    @RequestMapping(value="/homeissuer",method= RequestMethod.GET)
    public String homeissuer()
    {
        return "homeissuer";
    }

    @PassToken
    @RequestMapping(value="/homeadmin",method= RequestMethod.GET)
    public String homeadmin()
    {
        return "homeadmin";
    }

    @PassToken
    @RequestMapping(value="/homedeveloper",method= RequestMethod.GET)
    public String homedeveloper()
    {
        return "homedeveloper";
    }

    @PassToken
    @RequestMapping(value="/create",method= RequestMethod.GET)
    public String create() { return "create"; }

    @PassToken
    @RequestMapping(value="/createTask",method= RequestMethod.GET)
    public String createTask() { return "createTask"; }

    @PassToken
    @RequestMapping(value="/register",method= RequestMethod.GET)
    public String register() { return "register"; }

    @PassToken
    @RequestMapping(value="/createDev",method= RequestMethod.GET)
    public String createDev() { return "createDev"; }

    @RequestMapping(value="/myTask",method= RequestMethod.GET)
    public String myTask()
    {
        return "myTask";
    }

    @RequestMapping(value="/currentTask",method= RequestMethod.GET)
    public String currentTask()
    {
        return "currentTask";
    }

    @RequestMapping(value="/oldallot",method= RequestMethod.GET)
    public String oldallot()
    {
        return "oldallot";
    }

    @RequestMapping(value="/allot",method= RequestMethod.GET)
    public String allot()
    {
        return "allot";
    }

    @RequestMapping(value="/issuerCheck",method= RequestMethod.GET)
    public String issuerCheck()
    {
        return "issuerCheck";
    }

    @RequestMapping(value="/issuerCheck1",method= RequestMethod.GET)
    public String issuerCheck1()
    {
        return "issuerCheck1";
    }

    @RequestMapping(value="/adminCheck",method= RequestMethod.GET)
    public String adminCheck()
    {
        return "adminCheck";
    }

    @RequestMapping(value="/adminCheck1",method= RequestMethod.GET)
    public String adminCheck1()
    {
        return "adminCheck1";
    }

    @PassToken
    @RequestMapping(value="/taskList",method= RequestMethod.GET)
    public String taskList()
    {
        return "taskList";
    }

    @PassToken
    @RequestMapping(value="/taskCard",method= RequestMethod.GET)
    public String taskCard()
    {
        return "taskCard";
    }



}

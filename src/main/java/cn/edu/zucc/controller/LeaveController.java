package cn.edu.zucc.controller;

import cn.edu.zucc.common.R;
import cn.edu.zucc.Annotation.Role;
import cn.edu.zucc.Annotation.UserLoginToken;
import cn.edu.zucc.domain.entity.Leave;
import cn.edu.zucc.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/", method = RequestMethod.GET) //所有用户的所有请假列表（限管理员）
    public R<List<Leave>> getLists() {
        return R.data(leaveService.getAllLists());
    }

    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/Pending", method = RequestMethod.GET) //所有用户的发起请假列表（限管理员）
    public R<List<Leave>> getAllInitiatingList() {
        return R.data(leaveService.getAllInitiatingList());
    }

    @UserLoginToken
    @RequestMapping(value="/{name}", method = RequestMethod.GET) //当前用户所有请假单列表
    public R<List<Leave>> getLists(@PathVariable String name) {
        return R.data(leaveService.getLists(name));
    }

    @UserLoginToken
    @RequestMapping(value="/create", method = RequestMethod.POST) //发起请假
    public R<String> postLeave(@Valid @ModelAttribute Leave leave) {
        return R.success("success");
    }

    @Role("admin")
    @UserLoginToken
    @RequestMapping(value="/approval", method = RequestMethod.PUT) //审批
    public R<String> putLeave(@RequestParam Long id, @RequestParam String name, @RequestParam String state, @RequestParam String remarks) {
        Leave leave = leaveService.getList(id, name);
        leave.setState(state);
        leave.setRemarks(remarks);
        leaveService.approval(leave);
        return R.success("success");
    }
}

package cn.edu.zucc.controller;

import cn.edu.zucc.common.R;
import cn.edu.zucc.domain.entity.Task;
import cn.edu.zucc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/create", method = RequestMethod.POST) //创建任务
    public R<String> create(@RequestBody @Valid Task task) {
        taskService.create(task);
        return R.success("success");
    }

    @RequestMapping(value="taskList/{contractor}", method = RequestMethod.GET) //当前承包商设置的任务
    public R<List<Task>> gettaskList(@PathVariable String contractor) {
        return R.data(taskService.gettaskList(contractor));
    }

    @RequestMapping(value="taskList/p/{project}", method = RequestMethod.GET) //当前项目的任务
    public R<List<Task>> getptaskList(@PathVariable String project) {
        return R.data(taskService.getptaskList(project));
    }

    @RequestMapping(value="/{developer}", method = RequestMethod.GET) //当前开发人员所有的任务
    public R<List<Task>> getMytasks(@PathVariable String developer) {
        return R.data(taskService.getMytasks(developer));
    }

    @RequestMapping(value="/current/{developer}", method = RequestMethod.GET) //开发人员的当前任务
    public R<List<Task>> getMyCtasks(@PathVariable String developer) {
        return R.data(taskService.getMyCtasks(developer));
    }

    @RequestMapping(value="/finish/{id}", method = RequestMethod.POST) //完成任务
    public R<String> finish(@PathVariable Long id, @RequestBody @Valid Task finished, BindingResult bindingResult) {
        Task task = taskService.getList(id);
        task.setState(finished.getState());
        task.setEnd(finished.getEnd());
        task.setReal_pd(finished.getReal_pd());
        taskService.finish(task);
        return R.success("success");
    }

    @RequestMapping(value="/allot/{id}", method = RequestMethod.POST) //分配任务
    public R<String> allot(@PathVariable Long id, @RequestBody @Valid Task finished, BindingResult bindingResult) {
        Task task = taskService.getList(id);
        task.setState(finished.getState());
        task.setStart(finished.getStart());
        taskService.finish(task);
        return R.success("success");
    }

    @RequestMapping(value="myTask/{id}", method = RequestMethod.GET) //开发人员的任务详情
    public R<Task> getTask(@PathVariable Long id) {
        return R.data(taskService.getList(id));
    }

    @RequestMapping(value="/total/{project}", method = RequestMethod.GET) //项目开发人数
    public R<String> total(@PathVariable String project) {
        return R.data(taskService.total(project));
    }

    @RequestMapping(value="/finished/{project}", method = RequestMethod.GET) //项目未完成的任务数
    public R<String> finished(@PathVariable String project) {
        return R.data(taskService.finished(project));
    }

    @RequestMapping(value="/count/{project}", method = RequestMethod.GET) //项目总任务数
    public R<String> count(@PathVariable String project) {
        return R.data(taskService.count(project));
    }
}

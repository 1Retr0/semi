package cn.edu.zucc.service;

import cn.edu.zucc.domain.entity.Task;

import java.util.List;

public interface TaskService {
    void create(Task Task); //创建任务
    //void allot(Task Task); //
    void finish(Task task);
    List<Task> getMytasks(String developer); //我的任务列表
    List<Task> getMyCtasks(String developer); //我的当前任务列表
    Task getList(Long id); //完成的任务
    List<Task> gettaskList(String contractor);
    List<Task> getptaskList(String project);
    String total(String project); //一个项目人数统计
    String finished(String task); //一个项目未完成任务的统计
    String count(String task); //一个项目未完成任务的统计
}

package cn.edu.zucc.service;

import cn.edu.zucc.domain.entity.Project;

import java.util.List;

public interface ProjectService {
    void create(Project project); //创建项目
    void publish(Project project); //发布项目
    void accept(Project project); //验收项目
    void contract(Project project); //承包项目
    Project getList(Long id); //待发布的项目
    Project getId(String name); //根据项目名找Id
    List<Project> getSearch(String issuer, String name);
    List<Project> getSearch2(String contractor, String name);
    List<Project> getAll(String name, String state); //当前发包方的项目
    List<Project> getContracted(String contractor); //当前承包方的项目
    List<Project> getPublished(); //获取已发布的项目列表
    List<Project> getAccept(); //获取已发布的项目列表
    List<Project> getLists();
//    Project getList(String name); //当前账号的项目详情与开发任务进度
//    Project getList(Long id, String name); //当前账号的项目详情与开发任务进度
    List<Project> getAll(String issuer); //当前账号的项目详情与开发任务进度
//    List<Leave> getAllLists(); //所有用户的所有请假列表
//    List<Leave> getAllInitiatingList(); //所有用户的发起请假列表
//    Leave getList(Long id); //所有用户的发起请假列表
}

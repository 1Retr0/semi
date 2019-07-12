package cn.edu.zucc.service.impl;

import cn.edu.zucc.domain.dao.ProjectRepository;
import cn.edu.zucc.domain.entity.Project;
import cn.edu.zucc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void create(Project project) { projectRepository.save(project); } //创建项目

    @Override
    public void publish(Project project) { projectRepository.save(project); } //创建项目

    @Override
    public void accept(Project project) { projectRepository.save(project); } //验收项目

    @Override
    public void contract(Project project)  { projectRepository.save(project); }//承包项目

    @Override
    public List<Project> getAll(String issuer) {
        return projectRepository.findByIssuer(issuer);
    } //当前账号的项目详情与开发任务进度

    @Override
    public Project getList(Long id) {
        return projectRepository.findList(id);
    }

    @Override
    public List<Project> getSearch(String issuer, String name) {
        return projectRepository.findByIssuerAndName(issuer,name);
    }

    @Override
    public List<Project> getSearch2(String contractor, String name) {
        return projectRepository.findByContractorAndName(contractor,name);
    }

    @Override
    public Project getId(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public List<Project> getAll(String issuer, String state) {
        return projectRepository.findByIssuerAndState(issuer, state);
    } //当前账号的项目详情与开发任务进度


    @Override
    public List<Project> getPublished() {
        return projectRepository.findByState("已发布");
    } //已发布项目列表

    @Override
    public List<Project> getAccept() {
        return projectRepository.findByState("待验收");
    } //已发布项目列表

    public List<Project> getLists() {
        return projectRepository.findLists();
    } //当前账号的项目详情与开发任务进度

    public List<Project> getContracted(String contractor) {
        return projectRepository.findByContractor(contractor);
    } //当前账号的项目详情与开发任务进度
}

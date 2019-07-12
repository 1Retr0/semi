package cn.edu.zucc.controller;

import cn.edu.zucc.common.R;
import cn.edu.zucc.domain.entity.Project;
import cn.edu.zucc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;


    @RequestMapping(value = "/create", method = RequestMethod.POST) //创建项目
    public R<String> create(@RequestBody @Valid Project project) {
        projectService.create(project);
        return R.success("success");
    }

    @RequestMapping(value = "/search/{issuer}/{name}", method = RequestMethod.GET) //查询项目
    public R<List<Project>> getSearch(@PathVariable String issuer, @PathVariable String name) {
        return R.data(projectService.getSearch(issuer,name));
    }
    @RequestMapping(value = "/search2/{contractor}/{name}", method = RequestMethod.GET) //查询项目
    public R<List<Project>> getSearch2(@PathVariable String contractor, @PathVariable String name) {
        return R.data(projectService.getSearch2(contractor,name));
    }
    @RequestMapping(value="/1/{id}", method = RequestMethod.GET) //获取要发布的项目信息
    public R<Project> getList(@PathVariable Long id) {
        return R.data(projectService.getList(id));
    }

    @RequestMapping(value="/id/{name}", method = RequestMethod.GET) //根据项目名找项目Id
    public R<Project> getId(@PathVariable String name) {
        return R.data(projectService.getId(name));
    }

    @RequestMapping(value="/publish/{id}", method = RequestMethod.POST) //发布项目
    public R<String> publish(@PathVariable Long id, @RequestBody @Valid Project published, BindingResult bindingResult) {
        Project unpublished = projectService.getList(id);
        unpublished.setState(published.getState());
        unpublished.setDescription(published.getDescription());
        projectService.publish(unpublished);
        return R.success("success");
    }

    @RequestMapping(value="/{issuer}", method = RequestMethod.GET) //当前发包方的所有项目
    public R<List<Project>> getAll(@PathVariable String issuer) {
        return R.data(projectService.getAll(issuer));
    }

    @RequestMapping(value="/unpublished/{issuer}", method = RequestMethod.GET) //当前发包方的未发布的项目
    public R<List<Project>> getUnpublished(@PathVariable String issuer) {
        return R.data(projectService.getAll(issuer,"初始化"));
    }

    @RequestMapping(value="/contracted/{contractor}", method = RequestMethod.GET) //当前承包方承包的所有项目
    public R<List<Project>> getContracted(@PathVariable String contractor) {
        return R.data(projectService.getContracted(contractor));
    }

    @RequestMapping(value="/{issuer}/{state}", method = RequestMethod.GET) //当前发包方已发布项目列表
    public R<List<Project>> getLists(@PathVariable String issuer, @PathVariable String state) {
        return R.data(projectService.getAll(issuer, state));
    }

    @RequestMapping(value = "/contract", method = RequestMethod.GET) //获取所有已发布的项目
    public R<List<Project>> contract() {
        return R.data(projectService.getLists());
    }

    @RequestMapping(value="/2/{id}", method = RequestMethod.GET) //获取要承包的项目信息
    public R<Project> getCList(@PathVariable Long id) {
        return R.data(projectService.getList(id));
    }

    @RequestMapping(value = "/contract/{id}", method = RequestMethod.POST) //承包项目
    public R<String> contract(@PathVariable Long id, @RequestBody @Valid Project contracted, BindingResult bindingResult) {
        Project published = projectService.getList(id);
        published.setState(contracted.getState());
        published.setContractor(contracted.getContractor());
        published.setStart(contracted.getStart());
        projectService.contract(published);
        return R.success("success");
    }

    @RequestMapping(value = "/accept", method = RequestMethod.GET) //获取所有待验收的项目
    public R<List<Project>> accept() {
        return R.data(projectService.getAccept());
    }

    @RequestMapping(value = "/accept/{id}", method = RequestMethod.POST) //验收项目
    public R<String> accept(@PathVariable Long id, @RequestBody @Valid Project accepted, BindingResult bindingResult) {
        Project finished = projectService.getList(id);
        finished.setState(accepted.getState());
        finished.setEnd(accepted.getEnd());
        finished.setReal_pd(accepted.getReal_pd());
        projectService.contract(finished);
        return R.success("success");
    }

}

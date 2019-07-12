package cn.edu.zucc.service.impl;

import cn.edu.zucc.domain.dao.TaskRepository;
import cn.edu.zucc.domain.entity.Task;
import cn.edu.zucc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void create(Task task) { taskRepository.save(task); } //创建任务

    @Override
    public void finish(Task task) { taskRepository.save(task); } //完成任务

    @Override
    public List<Task> getMytasks(String developer) {
        return taskRepository.findByDeveloper(developer);
    }

    @Override
    public List<Task> getMyCtasks(String developer) {
        return taskRepository.findByDeveloperAndState(developer);
    }

    public List<Task> gettaskList(String contractor) {
        return taskRepository.findByContractor(contractor);
    }

    public List<Task> getptaskList(String project) {
        return taskRepository.findByProject(project);
    }

    @Override
    public Task getList(Long id) {
        return taskRepository.findList(id);
    }

    @Override
    public String total(String project) {
        return taskRepository.total(project);
    }

    @Override
    public String finished(String project) { return taskRepository.finished(project); }

    @Override
    public String count(String project) { return taskRepository.count(project); }
}

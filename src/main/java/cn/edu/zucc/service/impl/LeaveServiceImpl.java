package cn.edu.zucc.service.impl;

import cn.edu.zucc.domain.dao.LeaveRepository;
import cn.edu.zucc.domain.entity.Leave;
import cn.edu.zucc.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public void create(Leave leave) {
        leaveRepository.save(leave);
    } //发起请假

    @Override
    public void approval(Leave leave) {
        leaveRepository.save(leave);
    } //审批

    @Override
    public List<Leave> getLists(String petitioner) {
        return leaveRepository.findlists(petitioner);
    } //当前用户所有请假单列表

    @Override
    public Leave getList(Long id, String petitioner) {
        return leaveRepository.findlist(id, petitioner);
    } //当前用户所有请假单列表

    @Override
    public List<Leave> getAllLists() {
        return leaveRepository.findAll();
    } //所有用户的所有请假列表

    @Override
    public List<Leave> getAllInitiatingList() {
        return leaveRepository.findAllInitiating();
    } //所有用户的发起请假列表（限管理员）
}

package cn.edu.zucc.service;

import cn.edu.zucc.domain.entity.Leave;

import java.util.List;

public interface LeaveService {
    void create(Leave leave); //发起请假
    void approval(Leave leave); //审批
    List<Leave> getLists(String petitioner); //当前用户所有请假单列表
    Leave getList(Long id, String petitioner); //当前用户所有请假单列表
    List<Leave> getAllLists(); //所有用户的所有请假列表
    List<Leave> getAllInitiatingList(); //所有用户的发起请假列表
}

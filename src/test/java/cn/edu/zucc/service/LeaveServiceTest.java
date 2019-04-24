package cn.edu.zucc.service;

import cn.edu.zucc.StudioDemoApplicationTests;
import cn.edu.zucc.domain.entity.Leave;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.hamcrest.core.Is.is;

public class LeaveServiceTest extends StudioDemoApplicationTests {
    @Autowired
    LeaveService leaveService;
    @Test
    public void testAcreate() {
        Leave leave = new Leave();
        leave.setPetitioner("Avon");
        leave.setStart("2019-04-02 13:00:00");
        leave.setEnd("2019-04-03 09:00:00");
        leave.setTotal(1);
        leave.setAdministrator("admin");
        leave.setType("病假");
        leave.setReason("头痛");
        leave.setState("未通过");
        leave.setRemarks("无");
        leaveService.create(leave);
        Assert.assertThat(leave.getId(), is(1l));
    }
    @Test
    public void testBapproval() {
        Leave leave  = new Leave();
        leave.setId(1l);
        leave.setPetitioner("Avon");
        leave.setStart("2019-04-02 13:00:00");
        leave.setEnd("2019-04-03 09:00:00");
        leave.setTotal(1);
        leave.setAdministrator("admin");
        leave.setType("病假");
        leave.setReason("头痛");
        leave.setState("未通过");
        leave.setRemarks("忍着！");
        leaveService.approval(leave);
        Assert.assertThat(leave.getPetitioner(), is(leave.getPetitioner()));
    }
    @Test
    public void testCgetList() {
        Leave leave = leaveService.getList(1l, "Avon");
        Assert.assertThat(1l, is(leave.getId()));

    }
}

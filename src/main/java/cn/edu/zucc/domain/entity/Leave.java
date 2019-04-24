package cn.edu.zucc.domain.entity;

import cn.edu.zucc.common.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity(name = "leavelist")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "注解声明：申请人不能为空")
    private String petitioner; //申请人
    //java.sql.Date start = new java.sql.Date(new java.util.Date().getTime());
    //java.sql.Date end = new java.sql.Date(new java.util.Date().getTime());  //请假结束时间
    //java.sql.Date start = new java.sql.Date(new java.util.Date().getTime()); //请假开始时间
    //java.sql.Date end = new java.sql.Date(new java.util.Date().getTime()); ////请假结束时间
    @Date(message = "时间格式必须为yyyy-mm-dd HH:mm:ss")
    private String start;
    @Date(message = "时间格式必须为yyyy-mm-dd HH:mm:ss")
    private String end;
    private Integer total; //请假合计天数
    @NotEmpty(message = "注解声明：审批人不能为空")
    private String administrator; //审批人
    @NotEmpty(message = "注解声明：请假类型不能为空")
    private String type; //请假类型
    @NotEmpty(message = "注解声明：请假原因不能为空")
    private String reason; //请假原因
    private String state; //状态
    private String remarks; //批语

    public String getPetitioner() {
        return petitioner;
    }

    public void setPetitioner(String petitioner) {
        this.petitioner = petitioner;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

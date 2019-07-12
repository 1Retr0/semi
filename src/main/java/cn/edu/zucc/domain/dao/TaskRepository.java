package cn.edu.zucc.domain.dao;

import cn.edu.zucc.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("from task t where t.developer=:developer")
    List<Task> findByDeveloper(@Param("developer") String developer);

    @Query("from task t where t.developer=:developer and t.state='已分配'")
    List<Task> findByDeveloperAndState(@Param("developer") String developer);

    @Query("from task t where t.contractor=:contractor")
    List<Task> findByContractor(@Param("contractor") String contractor);

    @Query("from task t where t.project=:project")
    List<Task> findByProject(@Param("project") String project);


    @Query("from task t where t.id=:id")
    Task findList(@Param("id") Long id);

    @Query("SELECT COUNT(project) AS total FROM task t WHERE t.project=:project")
    String total(@Param("project") String project);

    @Query("SELECT COUNT(project) AS count FROM task t WHERE t.project=:project")
    String count(@Param("project") String project);

    @Query("SELECT COUNT(project) AS count FROM task t WHERE t.project=:project and state='已完成'")
    String finished(@Param("project") String project);

}

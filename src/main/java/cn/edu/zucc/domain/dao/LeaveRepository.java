package cn.edu.zucc.domain.dao;

import cn.edu.zucc.domain.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    //Leave findByName(String name);

    @Query("from leavelist l where l.petitioner=:name")
    List<Leave> findlists(@Param("name") String name);

    @Query("from leavelist l where l.id=:id and l.petitioner=:name")
    Leave findlist(@Param("id") Long id, @Param("name") String name);

    @Query("from leavelist l where l.state='未通过'")
    List<Leave> findAllInitiating();
}

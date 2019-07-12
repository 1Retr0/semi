package cn.edu.zucc.domain.dao;

import cn.edu.zucc.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("from project p where p.issuer=:issuer")
    List<Project> findByIssuer(@Param("issuer") String issuer);

    @Query("from project p where p.id=:id")
    List<Project> findByPId(@Param("id") Long id);

    @Query("from project p where p.contractor=:contractor")
    List<Project> findByContractor(@Param("contractor") String contractor);

    @Query("from project p where p.issuer=:issuer and p.state=:state")
    List<Project> findByIssuerAndState(@Param("issuer")String issuer, @Param("state")String state);

    @Query("from project p where p.issuer=:issuer and p.name like %:name%")
    List<Project> findByIssuerAndName(@Param("issuer")String issuer, @Param("name")String name);

    @Query("from project p where p.contractor=:contractor and p.name like %:name%")
    List<Project> findByContractorAndName(@Param("contractor")String contractor, @Param("name")String name);

    @Query("from project p where p.id=:id")
    Project findList(@Param("id") Long id);


    @Query("from project p where p.name=:name")
    Project findByName(@Param("name") String name);

    @Query("from project p where p.state=:state")
    List<Project> findByState(@Param("state") String state);

    @Query("from project p where p.state='已发布' or p.state='已承包'")
    List<Project> findLists();
}

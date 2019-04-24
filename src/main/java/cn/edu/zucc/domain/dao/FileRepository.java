package cn.edu.zucc.domain.dao;

import cn.edu.zucc.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.file.Files;
import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    @Query(value="select * from File f where f.Uid=:uid",nativeQuery = true)
    List<Files> findByUid(@Param("uid") Long uid);

    @Query(value="from File f where f.Uid=:uid and f.Fname=:fname")
    Files findByUidAndFname(@Param("uid") Long uid,@Param("fname") String fname);
}

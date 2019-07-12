package cn.edu.zucc.domain.dao;

import cn.edu.zucc.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    @Query("from user u where u.name like %:name%")
    User findUser(@Param("name") String name);

    @Query("from user u where u.name=:name and u.password=:password")
    User findByNameAndPassword(@Param("name")String name, @Param("password")String password);

    @Query("from user u where u.superior=:superior")
    List<User> findBySuperior(@Param("superior")String superior);

}


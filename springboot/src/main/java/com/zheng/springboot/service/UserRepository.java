package com.zheng.springboot.service;

import com.zheng.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZhangShuzheng on 2016/11/17.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

	User findByNameAndAge(String name, Integer age);

	@Query("from User u where u.name=:name")
	User findUser(@Param("name") String name);
}

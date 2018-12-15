package org.balu.learn.repository;

import org.balu.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}

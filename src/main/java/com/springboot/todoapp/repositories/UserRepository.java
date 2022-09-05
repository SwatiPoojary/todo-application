package com.springboot.todoapp.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.todoapp.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUserName(String username);
}

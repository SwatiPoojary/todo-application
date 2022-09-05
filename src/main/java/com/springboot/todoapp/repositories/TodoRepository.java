package com.springboot.todoapp.repositories;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.todoapp.entity.Todo;

@Transactional
public interface TodoRepository extends JpaRepository<Todo, Long> {

	@Query(value = "SELECT * FROM Todo td WHERE td.user_name= :userId",
            nativeQuery = true)
	List<Todo> queryBy(@Param("userId") long userId);
	
}

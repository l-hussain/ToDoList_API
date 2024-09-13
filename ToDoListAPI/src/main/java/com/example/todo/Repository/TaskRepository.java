package com.example.todo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}

package com.alessandro.computershare.database.dao;

import com.alessandro.computershare.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findAllByDeveloper(Integer devId);
}

package com.alessandro.computershare.database.dao;

import com.alessandro.computershare.database.entity.Developer;
import com.alessandro.computershare.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
  List<Task> findAllByDeveloper(@Param("developer") Developer devId);
}

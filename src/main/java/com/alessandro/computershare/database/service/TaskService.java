package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dto.TaskDTO;
import com.alessandro.computershare.database.entity.Developer;

import java.util.List;

public interface TaskService {

  TaskDTO saveTask(TaskDTO dto);
  TaskDTO updateTask(TaskDTO dto);
  TaskDTO findTaskById(Integer id);
  List<TaskDTO> getAllTasks();
  List<TaskDTO> getTasksByDeveloper(Developer id);
  void deleteTask(TaskDTO dto);
}

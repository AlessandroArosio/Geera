package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.dto.TaskDTO;

import java.util.List;

public interface TaskService {

  TaskDTO saveTask(TaskDTO dto);
  TaskDTO updateTask(TaskDTO dto);
  TaskDTO findTaskById(Integer id);
  List<TaskDTO> getAllTasks();
  List<TaskDTO> getTasksByDeveloper(DeveloperDTO id);
  void deleteTask(TaskDTO dto);
}

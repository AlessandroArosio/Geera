package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dto.TaskDTO;
import com.alessandro.computershare.database.dto.mapper.TaskMapper;

import java.util.List;

public interface TaskService {

  TaskDTO saveTask(TaskDTO dto);
  TaskDTO updateTask(TaskDTO dto);
  TaskDTO findTaskById(Integer id);
  List<TaskDTO> getAllTasks();
  List<TaskDTO> getTasksByDevId();
  void deleteTask(TaskDTO dto);
}

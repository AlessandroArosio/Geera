package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dao.TaskRepository;
import com.alessandro.computershare.database.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository repository;

  @Override
  public TaskDTO saveTask(TaskDTO dto) {
    return null;
  }

  @Override
  public TaskDTO updateTask(TaskDTO dto) {
    return null;
  }

  @Override
  public TaskDTO findTaskById(Integer id) {
    return null;
  }

  @Override
  public List<TaskDTO> getAllTasks() {
    return null;
  }

  @Override
  public List<TaskDTO> getTasksByDevId() {
    return null;
  }

  @Override
  public void deleteTask(TaskDTO dto) {

  }
}

package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dao.TaskRepository;
import com.alessandro.computershare.database.dto.TaskDTO;
import com.alessandro.computershare.database.dto.mapper.TaskMapper;
import com.alessandro.computershare.database.entity.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository repository;

  @Autowired
  private TaskMapper mapper;

  @Override
  public TaskDTO saveTask(TaskDTO dto) {
    var task = mapper.dtoToTask(dto);
    var persistedTask = repository.save(task);
    return mapper.taskToDTO(persistedTask);
  }

  @Override
  public TaskDTO updateTask(TaskDTO dto) {
    var task = mapper.dtoToTask(dto);
    var persistedTask = repository.save(task);
    return mapper.taskToDTO(persistedTask);
  }

  @Override
  public TaskDTO findTaskById(Integer id) {
    var taskFromDB = repository.findById(id);
    return mapper.taskToDTO(taskFromDB.orElseThrow(RuntimeException::new));
  }

  @Override
  public List<TaskDTO> getAllTasks() {
    return repository.findAll().stream().map(mapper::taskToDTO).collect(Collectors.toList());
  }

  @Override
  public List<TaskDTO> getTasksByDeveloper(Developer id) {
    return repository.findAllByDeveloper(id).stream().map(mapper::taskToDTO).collect(Collectors.toList());
  }

  @Override
  public void deleteTask(TaskDTO dto) {
    repository.delete(mapper.dtoToTask(dto));
  }
}

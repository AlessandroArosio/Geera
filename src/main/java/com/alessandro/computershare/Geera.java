package com.alessandro.computershare;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.dto.TaskDTO;
import com.alessandro.computershare.database.entity.support.TaskType;
import com.alessandro.computershare.database.service.DeveloperService;
import com.alessandro.computershare.database.service.TaskService;
import com.alessandro.computershare.ui.CommandView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Geera implements CommandLineRunner {

  @Autowired
  private DeveloperService developerService;

  @Autowired
  private TaskService taskService;

  public static void main(String[] args) {
    SpringApplication.run(Geera.class, args);
  }

  @Override
  public void run(String... args) {
//    TaskDTO task1 = new TaskDTO();
//    task1.setDescription("task 1");
//    task1.setPriority(1);
//    task1.setTaskType(TaskType.BUG);
//
//    TaskDTO task2 = new TaskDTO();
//    task2.setDescription("task 2");
//    task2.setPriority(6);
//    task2.setTaskType(TaskType.FEATURE);
//    List<TaskDTO> tasks = new ArrayList<>();
//    tasks.add(task1);
//    tasks.add(task2);
//
//    DeveloperDTO dev = new DeveloperDTO();
//    dev.setName("Test Dev");
//    dev.setEmail("Email");
//    dev.setTaskList(tasks);
//
//    DeveloperDTO savedDev = developerService.saveDev(dev);
//    System.out.println("Dev name BEFORE save: " + dev.getName());
//
//    DeveloperDTO fromDB = developerService.findDevById(savedDev.getId());
//    System.out.println("Email from guy fetched: " + fromDB.getEmail());

    CommandView application = new CommandView();
    application.run();

  }
}

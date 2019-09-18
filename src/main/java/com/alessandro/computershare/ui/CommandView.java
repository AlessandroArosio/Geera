package com.alessandro.computershare.ui;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.dto.TaskDTO;
import com.alessandro.computershare.database.entity.support.TaskType;
import com.alessandro.computershare.database.service.DeveloperService;
import com.alessandro.computershare.database.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandView {

  private static final String DIVISOR = "\n\n===========================";
  private static final String LOGO = "==== Welcome to Geera ====";
  private static final String HELP =
      "\nPress 9 for HELP" +
          "\nPress 1 to add a developer" +
          "\nPress 2 to delete a developer" +
          "\nPress 3 to view developer info" +
          "\nPress 4 to view all developers" +
          "\nPress 5 to view all tasks available" +
          "\nPress 6 to create a new task" +
          "\nPress 7 to delete a task" +
          "\nPress 8 to assign a task";

  private static final String MAIN_MENU = "Press a number from 1 to 9.\nAny letter to quit the application\n";
  private static final String END_OF_LIST = "=== END of list ===";

  private DeveloperService developerService;
  private TaskService taskService;

  @Autowired
  public CommandView(DeveloperService developerService, TaskService taskService) {
    this.developerService = developerService;
    this.taskService = taskService;
  }

  private void printLogo() {
    System.out.println(DIVISOR);
    System.out.println(LOGO);
  }

  private void showHelpMenu() {
    System.out.println(HELP);
  }

  private void selectionMenu() {
    System.out.println(MAIN_MENU);
    Scanner scanner = new Scanner(System.in);;
    while (scanner.hasNextInt()) {
      int selection = scanner.nextInt();
      if (selection > 0 && selection < 10) {
        switch (selection) {
          case 1 -> addDeveloper();
          case 2 -> deleteDeveloper();
          case 3 -> devInfo();
          case 4 -> getAllDevs();
          case 5 -> getAllTasks();
          case 6 -> createTask();
          case 7 -> deleteTask();
          case 8 -> assignTask();
          case 9 -> showHelpMenu();
        }
      } else {
        System.out.printf("Unknown menu\n");
      }
      System.out.println(MAIN_MENU);
    }
  }

  public void run() {
    populateSomeData();
    printLogo();
    showHelpMenu();
    selectionMenu();
  }

  private void addDeveloper() {
    System.out.println("=== Add developer ===");
    DeveloperDTO developerDTO = new DeveloperDTO();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Add developer's name:\n");
    developerDTO.setName(scanner.nextLine());
    System.out.println("Add developer's email\n");
    developerDTO.setEmail(scanner.nextLine());
    System.out.println("Saving new developer to DB...");
    developerService.saveDev(developerDTO);
    System.out.println("Developer has been saved successfully!");
  }

  private void deleteDeveloper() {
    System.out.println("=== Delete developer ===");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Insert ID of the developer you want to delete");
    int devId = scanner.nextInt();
    try {
      DeveloperDTO devDTO = developerService.findDevById(devId);
      developerService.deleteDevById(devDTO.getId());
      System.out.println("Developer deleted");
    } catch (Exception e) {
      System.out.println("Dev with id " + devId + " not found. Exiting.");
    }
  }

  private void devInfo() {
    System.out.println("=== Developer info ===");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Insert ID of the developer you want to see");
    int devId = scanner.nextInt();
    try {
      DeveloperDTO devDTO = developerService.findDevById(devId);
      System.out.println("Developer's ID: " + devDTO.getId());
      System.out.println("Developer's name: " + devDTO.getName());
      System.out.println("Developer's email: " + devDTO.getEmail());
      System.out.println("\nCurrently working on task(s):\n");
      devDTO.getTaskList().forEach(e -> {
        System.out.println("Task ID: " + e.getId());
        System.out.println("Description: " + e.getDescription());
        System.out.println("Priority: " + e.getPriority());
        System.out.println("--------");
      });
    } catch (Exception e) {
      System.out.println("Dev with id " + devId + " not found. Exiting.");
    }
  }

  private void getAllDevs() {
    System.out.println("=== View all developers info ===");
    List<DeveloperDTO> devList = developerService.getAllDevs();
    devList.forEach(e ->
      System.out.println("Name: " + e.getName() + ", id: " + e.getId() + ", working on " + e.getTaskList().size() + " tasks")
    );
    System.out.println(END_OF_LIST);
  }

  private void getAllTasks() {
    System.out.println("=== View all tasks ===");
    List<TaskDTO> tasksList = taskService.getAllTasks();
    tasksList.forEach(e ->
      System.out.println("Task id: " + e.getId() + ", description: " + e.getDescription() + ", priority: " + e.getPriority())
    );
    System.out.println(END_OF_LIST);
  }

  private void createTask() {
    System.out.println("=== Create new task ===\n");
    TaskDTO taskDTO = new TaskDTO();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Type a description: ");
    taskDTO.setDescription(scanner.nextLine());
    System.out.println("Set the priority level (1 high, 10 low): ");
    taskDTO.setPriority(scanner.nextInt());
    System.out.println("Insert task type: (bug or feature)");
    scanner = new Scanner(System.in);
    String type = scanner.nextLine();
    switch (type) {
      case "bug" -> taskDTO.setTaskType(TaskType.BUG);
      case "feature" -> taskDTO.setTaskType(TaskType.FEATURE);
      default -> {
        taskDTO.setTaskType(null);
        System.out.println("Type not valid, setting default value (null)");
      }
    }
    taskService.saveTask(taskDTO);
  }

  private void deleteTask() {
    System.out.println("=== Delete task ===\n");
    System.out.println("... this will be implemented in the next release!\n");
  }

  private void assignTask() {
    System.out.println("=== Assign task to a developer ===\n");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Type the ID # of the task you want to assign:\n");
    try {
      int taskId = scanner.nextInt();
      var task = taskService.findTaskById(taskId);
      System.out.println("You have selected the task with id: " + task.getId());
      System.out.println("Now select the developer (type ID)\n");
      int devId = scanner.nextInt();
      var dev = developerService.findDevById(devId);
      System.out.println("Assigning the task to: " + dev.getName());
      dev.addTask(task);
      DeveloperDTO developerDTO = developerService.updateDev(dev);
      System.out.println(developerDTO.getName() + " got a new task!");
    } catch (Exception e) {
      System.out.println("An error has occurred, exiting. No task assigned");
    }
  }

  protected void populateSomeData() {
    DeveloperDTO dev = new DeveloperDTO();
    dev.setName("Alessandro");
    dev.setEmail("alessandro@email.com");

    TaskDTO task1 = new TaskDTO();
    task1.setDescription("null pointer");
    task1.setPriority(2);
    task1.setTaskType(TaskType.BUG);

    TaskDTO task2 = new TaskDTO();
    task2.setDescription("Add new thing");
    task2.setPriority(7);
    task2.setTaskType(TaskType.FEATURE);

    dev.addTask(task1);
    dev.addTask(task2);
    developerService.saveDev(dev);
  }
}

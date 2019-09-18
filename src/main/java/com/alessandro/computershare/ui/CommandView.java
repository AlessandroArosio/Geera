package com.alessandro.computershare.ui;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.service.DeveloperService;
import com.alessandro.computershare.database.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        // TODO actions here
        switch (selection) {
          case 1 -> addDeveloper();
          case 2 -> deleteDeveloper();
        }
      } else {
        System.out.printf("Unknown menu\n");
      }
      System.out.println(MAIN_MENU);
    }
  }

  public void run() {
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
}

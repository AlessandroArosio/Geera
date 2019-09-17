package com.alessandro.computershare.ui;

import java.util.Scanner;

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

  private void printLogo() {
    System.out.println(DIVISOR);
    System.out.println(LOGO);
  }

  private void showHelpMenu() {
    System.out.println(HELP);
  }

  private void selectionMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Press a number from 1 to 9.\nAny letter to quit the application");
    while (scanner.hasNextInt()) {
      if (scanner.nextInt() > 0 && scanner.nextInt() < 10) {
        // TODO actions here
      } else {
        System.out.printf("Unknown menu\n");
      }
    }
  }

  public void run() {
    printLogo();
    showHelpMenu();
    selectionMenu();
  }
}

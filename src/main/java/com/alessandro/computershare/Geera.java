package com.alessandro.computershare;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Geera implements CommandLineRunner {

  @Autowired
  private DeveloperService developerService;
  public static void main(String[] args) {
    SpringApplication.run(Geera.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    DeveloperDTO dev = new DeveloperDTO();
    dev.setName("Test Dev");
    dev.setEmail("Email");
    dev.setTaskList(new ArrayList<>());
    DeveloperDTO savedDev = developerService.saveDev(dev);
    System.out.println("Dev name BEFORE save: " + dev.getName());

    DeveloperDTO fromDB = developerService.findDevById(savedDev.getId());
    System.out.println("Email from guy fetched: " + fromDB.getEmail());
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Enter a name: ");
//
//    String name = scanner.nextLine();
//    System.out.println("you wrote: " + name);
  }
}

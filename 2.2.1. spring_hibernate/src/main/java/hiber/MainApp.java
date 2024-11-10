package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User(new Car("BMW",5),"User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User(new Car("BMW",2),"User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User(new Car("BMW",7),"User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User(new Car("LADA",3),"User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("Car = "+user.getCar());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(carService.listCars("BMW",5));
      context.close();
   }
}

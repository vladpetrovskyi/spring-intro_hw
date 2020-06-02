package hw.spring;

import hw.spring.config.AppConfig;
import hw.spring.model.User;
import hw.spring.service.UserService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Anton", 19));
        userService.add(new User("Zhenya", 33));
        userService.add(new User("Katya", 24));
        userService.add(new User("Anna", 30));

        List<User> userList = userService.listUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}

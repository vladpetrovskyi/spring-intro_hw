package hw.spring.controllers;

import hw.spring.dto.UserResponseDto;
import hw.spring.model.User;
import hw.spring.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/inject")
    public void inject() {
        userService.add(new User("Anton", 19));
        userService.add(new User("Zhenya", 33));
        userService.add(new User("Katya", 24));
        userService.add(new User("Anna", 30));

        List<User> userList = userService.listUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return getDtoFromUser(userService.getById(userId));
    }

    @GetMapping(value = "/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getDtoFromUser)
                .collect(Collectors.toList());
    }

    private UserResponseDto getDtoFromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setAge(user.getAge());
        userResponseDto.setName(user.getName());
        userResponseDto.setId(user.getId());
        return userResponseDto;
    }
}

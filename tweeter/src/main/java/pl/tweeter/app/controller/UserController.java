package pl.tweeter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tweeter.app.entity.User;
import pl.tweeter.app.model.UserDto;
import pl.tweeter.app.service.UserService;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        userList.sort(Comparator.comparing(post -> post.getCreateTimestamp()));
        model.addAttribute("users", userList);
        return "users";
    }

    @PostMapping("/banuser")
    public String banUser(@ModelAttribute("login") @Valid UserDto userDto, Long days) {
        userService.banUser(userDto, days);
        return "banuserresult";

    }
}

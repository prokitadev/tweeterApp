package pl.tweeter.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.tweeter.app.controller.UserController;
import pl.tweeter.app.model.User;
import pl.tweeter.app.repository.UserRepository;
import pl.tweeter.app.service.UserService;

@SpringBootApplication
public class TweeterApplication {

//	UserService userService;
//
//	@Autowired
//	public TweeterApplication(UserService userService) {
//		this.userService = userService;
//		System.out.println(userService.getAllUsers());
//	}

	public static void main(String[] args) {
		SpringApplication.run(TweeterApplication.class, args);
	}

}

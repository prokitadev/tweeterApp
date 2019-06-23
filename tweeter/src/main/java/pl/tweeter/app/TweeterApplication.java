package pl.tweeter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

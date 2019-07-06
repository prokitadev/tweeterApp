package pl.tweeter.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import pl.tweeter.app.entity.User;
import pl.tweeter.app.entity.UserDescription;
import pl.tweeter.app.model.UserDto;
import pl.tweeter.app.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private ActionService actionService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, ActionService actionService,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.actionService = actionService;
        this.passwordEncoder = passwordEncoder;

    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(u -> modelMapper.map(u, User.class))
                .collect(Collectors.toList());
    }

    public void banUser(UserDto userDto, Long days) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getName();

        actionService.createAction(days, userIdByLogin(userDto.getLogin()), userIdByLogin(userLogin));
    }

    private User userIdByLogin(String login) {

        return userRepository
                .findUserByLogin(login)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }

    public User loggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getName();
        return userRepository
                .findUserByLogin(userLogin)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void addNewUser(UserDto userDto, BindingResult bindingResult) {

        userRepository.save(prepareUser(userDto));

    }

    private User prepareUser (UserDto userDto) {

        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTimestamp(now);
        user.setRole("OBSERVER");

        UserDescription userDescription = new UserDescription();
        userDescription.setCreateTimestamp(now);

        user.setUserDescription(userDescription);

        return user;
    }

}

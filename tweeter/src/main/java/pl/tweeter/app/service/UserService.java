package pl.tweeter.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.tweeter.app.entity.User;
import pl.tweeter.app.model.UserDto;
import pl.tweeter.app.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private ActionService actionService;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, ActionService actionService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.actionService = actionService;
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
}

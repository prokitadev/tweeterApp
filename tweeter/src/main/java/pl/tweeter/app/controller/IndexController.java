package pl.tweeter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.tweeter.app.entity.User;
import pl.tweeter.app.model.PostDto;
import pl.tweeter.app.model.UserDto;
import pl.tweeter.app.service.PostService;
import pl.tweeter.app.service.UserService;

import java.util.Comparator;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;



    @RequestMapping(value = {"/", "/index"})
    public String get(Model model) {
        List<PostDto> postList = postService.getAllPosts();
        model.addAttribute("posts", postList);
        model.addAttribute("postToInsert", new PostDto());
        model.addAttribute("postToModify", new PostDto());
        model.addAttribute("postToDelete", new PostDto());
        model.addAttribute("commentToInsert", new PostDto());

        User user = userService.loggedUser();
        model.addAttribute("getUser", user);

        return "index";
    }







}

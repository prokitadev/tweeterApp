package pl.tweeter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.tweeter.app.model.PostDto;
import pl.tweeter.app.service.PostService;

import java.text.ParseException;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/modifypost")
        public ModelAndView modifyPost() {
            return new ModelAndView("index", "postToModify", new PostDto());
    }

    @PostMapping("/modifypost")
    public String modifyPost(@ModelAttribute PostDto postDto) {

        postService.editPost(postDto);

        return "index";
    }

    @GetMapping("/addpost")
    public ModelAndView addPost() {
        return new ModelAndView("index", "postToInsert", new PostDto());
    }

    @PostMapping("/addpost")
    public String addPost(@ModelAttribute PostDto postDto) throws ParseException {
        postService.savePost(postDto);
        return "index";
    }

}

package pl.tweeter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tweeter.app.model.PostDto;
import pl.tweeter.app.service.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/editpost")
    public void editPost(PostDto postDto, String edit) {

    }
}

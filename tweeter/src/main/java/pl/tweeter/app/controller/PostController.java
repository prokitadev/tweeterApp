package pl.tweeter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.tweeter.app.entity.Post;
import pl.tweeter.app.model.PostDto;
import pl.tweeter.app.service.PostService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

//    @GetMapping("/modifypost")
//        public ModelAndView modifyPost() {
//            return new ModelAndView("index", "postToModify", new PostDto());
//    }
//
//    @PostMapping("/modifypost")
//    public String modifyPost(@ModelAttribute PostDto postDto) {
//
//        postService.editPost(postDto);
//
//        return "modifypost";
//    }

//    @GetMapping("/addpost")
//    public ModelAndView addPost() {
//        return new ModelAndView("index", "postToInsert", new PostDto());
//    }
//
//    @PostMapping("/addpost")
//    public String addPost(@ModelAttribute PostDto postDto) throws ParseException {
//        postDto.setCreateTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//        postService.savePost(postDto);
//        return "modifypost";
//    }
    @GetMapping("/addpost")
    public String addPost(Model model) {
        model.addAttribute("postToInsert", new PostDto());
        return "index";
    }

    @PostMapping(value="/addpost")
    public String addPost(PostDto postDto) {
        postService.savePost(postDto);
        return "modifypost";
    }

    @PostMapping(value="/addcomment")
    public String addComment(PostDto postDto) {
        postService.addComment(postDto);
        return "modifypost";
    }

    @GetMapping("/modifypost")
    public String modifyPost(Model model) {
        model.addAttribute("postToModify", new PostDto());
        return "index";
    }

    @PostMapping(value="/modifypost")
    public String modifyPost(@ModelAttribute("postToModify") PostDto postDto) {
        postService.editPost(postDto);
        return "modifypost";
    }

    @PostMapping(value="/deletepost")
    public String deletePost(PostDto postDto) {
        postService.deletePost(postDto);
        return "modifypost";
    }
}

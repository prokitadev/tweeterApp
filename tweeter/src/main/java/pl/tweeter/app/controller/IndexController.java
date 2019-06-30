package pl.tweeter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tweeter.app.entity.Post;
import pl.tweeter.app.model.PostDto;
import pl.tweeter.app.service.PostService;

import java.util.Comparator;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    private PostService postService;

    @RequestMapping(value = {"/", "/index"})
    public String getPost(Model model) {
        List<PostDto> postList = postService.getAllPosts();
        postList.sort(Comparator.comparing(post -> post.getCreateTimestamp()));
        model.addAttribute("posts", postList);
        model.addAttribute("postToInsert", new PostDto());
        model.addAttribute("postToModify", new PostDto());
        return "index";
    }



}

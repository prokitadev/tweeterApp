package pl.tweeter.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tweeter.app.entity.Post;
import pl.tweeter.app.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(p -> modelMapper.map(p, Post.class))
                .collect(Collectors.toList());
    }


}

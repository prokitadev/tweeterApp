package pl.tweeter.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.tweeter.app.entity.Post;
import pl.tweeter.app.model.PostDto;
import pl.tweeter.app.repository.PostRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    public void editPost(PostDto postDto) {

    Post post = modelMapper.map(postDto, Post.class);
    post.setCreateTimestamp(Timestamp.valueOf(LocalDateTime.now()));
    post.setUserId(2);
    post.setPublic(true);
    post.setType("comment");

    postRepository.save(post);

    }

    public void savePost(PostDto postDto) {

        postDto.setCreateTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        postDto.setUserId(3);
        postDto.setPublic(true);
        postDto.setType("post");
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);


    }


    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(p -> modelMapper.map(p, Post.class))
                .collect(Collectors.toList());
    }


}

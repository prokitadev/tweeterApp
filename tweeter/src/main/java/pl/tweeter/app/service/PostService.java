package pl.tweeter.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.tweeter.app.entity.Post;
import pl.tweeter.app.entity.User;
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

        Post postTemp = postRepository.getOne(postDto.getId());
        postTemp.setModifyTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        postTemp.setText(postDto.getText());
        postRepository.save(postTemp);

    }

    public void savePost(PostDto postDto) {

        postDto.setCreateTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        postDto.setUserId(3L);
        postDto.setPublic(true);
        postDto.setType("post");
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);

    }


    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }


}

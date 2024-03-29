package pl.tweeter.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.tweeter.app.entity.Post;
import pl.tweeter.app.entity.User;
import pl.tweeter.app.model.PostDto;
import pl.tweeter.app.repository.PostRepository;
import pl.tweeter.app.repository.UserRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

    }

    public void editPost(PostDto postDto) { //dodac moze try catch, ktory wywali blad jezeli userid edytujacego nie jest rowne useris tworcy
        Post postTemp = postRepository.getOne(postDto.getId());
        postTemp.setModifyTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        postTemp.setText(postDto.getText());
        postRepository.save(postTemp);
    }

    public void savePost(PostDto postDto) {
        postDto.setCreateTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        postDto.setUserId(loggedUserId().getId());
        postDto.setPublic(true);
        postDto.setType("post");
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);
    }
    public void addComment(PostDto postDto) {
        postDto.setCreateTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        postDto.setUserId(loggedUserId().getId());
        postDto.setPublic(true);
        postDto.setType("comment");
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .filter(p -> p.getDeleteTimestamp() == null)
                .sorted(Comparator.comparing(PostDto::getCreateTimestamp).reversed())
                .collect(Collectors.toList());

    }

    public void deletePost(PostDto postDto) {
        Post postTemp = postRepository.getOne(postDto.getId());
        postTemp.setDeleteTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        postRepository.save(postTemp);
    }

    private User loggedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = authentication.getName();
        return userRepository.findUserByLogin(userLogin)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }


}

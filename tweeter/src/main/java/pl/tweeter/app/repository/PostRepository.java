package pl.tweeter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tweeter.app.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

package pl.tweeter.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tweeter.app.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
}

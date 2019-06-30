package pl.tweeter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.tweeter.app.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    Long countByUserId(Long userID);



}

package pl.tweeter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tweeter.app.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

}

package pl.tweeter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.tweeter.app.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

}

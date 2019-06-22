package pl.tweeter.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tweeter.app.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}

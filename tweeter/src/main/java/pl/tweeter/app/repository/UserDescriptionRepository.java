package pl.tweeter.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tweeter.app.model.UserDescription;

public interface UserDescriptionRepository extends CrudRepository<UserDescription, Integer> {
}

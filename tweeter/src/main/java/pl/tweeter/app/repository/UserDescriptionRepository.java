package pl.tweeter.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tweeter.app.entity.UserDescription;

public interface UserDescriptionRepository extends CrudRepository<UserDescription, Integer> {
}

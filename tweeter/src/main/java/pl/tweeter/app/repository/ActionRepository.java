package pl.tweeter.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tweeter.app.entity.Action;

public interface ActionRepository extends CrudRepository<Action, Integer> {
}

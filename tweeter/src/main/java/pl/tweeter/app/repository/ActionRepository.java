package pl.tweeter.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tweeter.app.model.Action;

public interface ActionRepository extends CrudRepository<Action, Integer> {
}

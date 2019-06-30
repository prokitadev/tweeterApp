package pl.tweeter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tweeter.app.entity.Action;

public interface ActionRepository extends JpaRepository<Action, Long> {
}

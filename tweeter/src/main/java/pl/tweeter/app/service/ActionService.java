package pl.tweeter.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tweeter.app.entity.Action;
import pl.tweeter.app.entity.User;
import pl.tweeter.app.repository.ActionRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class ActionService {

    private ActionRepository actionRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ActionService(ActionRepository actionRepository, ModelMapper modelMapper) {
        this.actionRepository = actionRepository;
        this.modelMapper = modelMapper;
    }


    public void createAction(Long days, User user, User admin) {
        Action action = new Action();
        action.setCreateTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        action.setType("banned");
        action.setExpireTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(days)));
        action.setUserId(user.getId());
        action.setAdminUserId(admin.getId());

        actionRepository.save(action);
    }
}

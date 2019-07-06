package pl.tweeter.app.model;

import pl.tweeter.app.entity.UserDescription;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class UserDto {

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDto() {
    }

    private Long id;
    private Timestamp createTimestamp;

    @Size(min=2, max=20, message = "login length should be between 2 and 20 chars")
    private String login;

    @Size(min=2, max=20, message = "password length should be between 2 and 20 chars")
    private String password;
    private RoleTypes role;
    private UserDescription userDescription;

    public UserDescription getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(UserDescription userDescription) {
        this.userDescription = userDescription;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleTypes getRole() {
        return role;
    }

    public void setRole(RoleTypes role) {
        this.role = role;
    }
}

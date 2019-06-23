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

    private Integer id;
    private Timestamp createTimestamp;

    @Size(min=2, max=20, message = "login length should be between 2 and 20 chars")
    private String login;

    @Size(min=2, max=20, message = "password length should be between 2 and 20 chars")
    private String password;
    private String role;
    private UserDescription userDescription;

    public UserDescription getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(UserDescription userDescription) {
        this.userDescription = userDescription;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

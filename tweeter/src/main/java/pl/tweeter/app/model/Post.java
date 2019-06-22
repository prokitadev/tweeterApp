package pl.tweeter.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime createTimestamp;
    private LocalDateTime modifyTimestamp;
    private LocalDateTime deleteTimestamp;
    private Integer userId;
    private String text;
    private boolean isPublic;
    private String type;
    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(LocalDateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public LocalDateTime getModifyTimestamp() {
        return modifyTimestamp;
    }

    public void setModifyTimestamp(LocalDateTime modifyTimestamp) {
        this.modifyTimestamp = modifyTimestamp;
    }

    public LocalDateTime getDeleteTimestamp() {
        return deleteTimestamp;
    }

    public void setDeleteTimestamp(LocalDateTime deleteTimestamp) {
        this.deleteTimestamp = deleteTimestamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}

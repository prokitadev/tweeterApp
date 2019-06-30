package pl.tweeter.app.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "t_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_timestamp")
    private Timestamp createTimestamp;

    @Column(name = "modify_timestamp")
    private Timestamp modifyTimestamp;

    @Column(name = "delete_timestamp")
    private Timestamp deleteTimestamp;

    private Long userId;

    private String text;

    @Column(name = "public")
    private boolean isPublic;
    private String type;

    private Long parentId;

    public Long getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Post(String text) {
        this.text = text;
    }

    public Post() {
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Timestamp getModifyTimestamp() {
        return modifyTimestamp;
    }

    public void setModifyTimestamp(Timestamp modifyTimestamp) {
        this.modifyTimestamp = modifyTimestamp;
    }

    public Timestamp getDeleteTimestamp() {
        return deleteTimestamp;
    }

    public void setDeleteTimestamp(Timestamp deleteTimestamp) {
        this.deleteTimestamp = deleteTimestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}

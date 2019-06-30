package pl.tweeter.app.model;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class PostDto {

    private Long id;
    private Timestamp createTimestamp;
    private Timestamp modifyTimestamp;
    private Timestamp deleteTimestamp;
    private Long userId;

    @Size(max = 299)
    private String text;
    private boolean isPublic;
    private String type;
    private Long parentId;

    public PostDto() {

    }

    public PostDto(String text) {
        this.text = text;
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

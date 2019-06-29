package pl.tweeter.app.model;

import java.sql.Timestamp;

public class PostDto {

    private Integer id;
    private Timestamp createTimestamp;
    private Timestamp modifyTimestamp;
    private Timestamp deleteTimestamp;
    private Integer userId;
    private String text;
    private boolean isPublic;
    private String type;
    private Integer parentId;

    public PostDto(Integer id) {

        this.id = id;
    }

    public PostDto() {
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

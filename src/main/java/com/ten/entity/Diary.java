package com.ten.entity;

public class Diary {

    private Integer id;
    private Integer diaryId;
    private Integer userId;
    private String diaryName;
    private String diaryText;
    private String createTime;
    private String updateTime;
    private Integer isDeleted;

    @Override
    public String toString() {
        return "Diary@{"
                + "id:" + id
                + ",diaryId:" + diaryId
                + ",userId:" + userId
                + ",diaryName:" + diaryName
                + ",diaryText:" + diaryText
                + ",createTime:" + createTime
                + ",updateTime:" + updateTime
                + ",isDeleted:" + isDeleted
                + "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public void setDiaryText(String diaryText) {
        this.diaryText = diaryText;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Integer diaryId) {
        this.diaryId = diaryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public String getdiaryText() {
        return diaryText;
    }

    public void setdiaryText(String diaryText) {
        this.diaryText = diaryText;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getdiaryGmtCreate() {
        return createTime;
    }

    public void setdiaryGmtCreate(String diaryGmtCreate) {
        this.createTime = diaryGmtCreate;
    }

    public String getdiaryGmtModified() {
        return updateTime;
    }

    public void setdiaryGmtModified(String diaryGmtModified) {
        this.updateTime = diaryGmtModified;
    }
}

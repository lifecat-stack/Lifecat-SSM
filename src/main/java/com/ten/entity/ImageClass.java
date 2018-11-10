package com.ten.entity;

/**
 * image_class
 *
 * @auther ten
 */
public class ImageClass {

    private Integer id;
    private Integer imageClassId;
    private String imageClassName;
    private String imageClassDesc;
    private String createTime;
    private String updateTime;

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageClassId() {
        return imageClassId;
    }

    public void setImageClassId(Integer imageClassId) {
        this.imageClassId = imageClassId;
    }

    public String getImageClassName() {
        return imageClassName;
    }

    public void setImageClassName(String imageClassName) {
        this.imageClassName = imageClassName;
    }

    public String getImageClassDesc() {
        return imageClassDesc;
    }

    public void setImageClassDesc(String imageClassDesc) {
        this.imageClassDesc = imageClassDesc;
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
}

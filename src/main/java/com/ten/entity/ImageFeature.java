package com.ten.entity;

/**
 * image_feature
 *
 * @auther ten
 */
public class ImageFeature {

    private Integer id;
    private Integer imageId;
    private Integer imageClassId;
    private String imageFeaturePath;
    private String featureGmtCreate;
    private String featureGmtModified;

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getImageClassId() {
        return imageClassId;
    }

    public void setImageClassId(Integer imageClassId) {
        this.imageClassId = imageClassId;
    }

    public String getImageFeaturePath() {
        return imageFeaturePath;
    }

    public void setImageFeaturePath(String imageFeaturePath) {
        this.imageFeaturePath = imageFeaturePath;
    }

    public String getFeatureGmtCreate() {
        return featureGmtCreate;
    }

    public void setFeatureGmtCreate(String featureGmtCreate) {
        this.featureGmtCreate = featureGmtCreate;
    }

    public String getFeatureGmtModified() {
        return featureGmtModified;
    }

    public void setFeatureGmtModified(String featureGmtModified) {
        this.featureGmtModified = featureGmtModified;
    }
}

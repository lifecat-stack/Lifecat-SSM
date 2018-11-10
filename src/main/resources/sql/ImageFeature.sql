-- auto Generated on 2018-11-10 21:10:56 
-- DROP TABLE IF EXISTS `image_feature`; 
CREATE TABLE image_feature(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `image_id` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'imageId',
    `image_class_id` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'imageClassId',
    `image_feature_path` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'imageFeaturePath',
    `feature_gmt_create` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'featureGmtCreate',
    `feature_gmt_modified` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'featureGmtModified',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'image_feature';

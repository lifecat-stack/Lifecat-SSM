-- auto Generated on 2018-11-10 21:10:46 
-- DROP TABLE IF EXISTS `image_class`; 
CREATE TABLE image_class(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `image_class_id` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'imageClassId',
    `image_class_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'imageClassName',
    `image_class_desc` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'imageClassDesc',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'image_class';

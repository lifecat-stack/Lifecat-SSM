-- auto Generated on 2018-11-10 21:11:16 
-- DROP TABLE IF EXISTS `user_property`; 
CREATE TABLE user_property(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'userId',
    `user_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'userName',
    `nickname` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'nickname',
    `signature` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'signature',
    `sex` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'sex',
    `email` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'email',
    `location` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'location',
    `birthday` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'birthday',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    `is_deleted` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'isDeleted',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_property';

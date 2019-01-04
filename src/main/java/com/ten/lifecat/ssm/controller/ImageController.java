package com.ten.lifecat.ssm.controller;

import com.ten.lifecat.ssm.dto.ResponseCode;
import com.ten.lifecat.ssm.dto.ResultModel;
import com.ten.lifecat.ssm.entity.Image;
import com.ten.lifecat.ssm.service.ImageService;
import com.ten.service.*;

import com.sun.istack.internal.NotNull;
import com.ten.lifecat.ssm.util.ControllerUtil;
import com.ten.lifecat.ssm.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.List;

@RestController
@RequestMapping("/image/v1")
public class ImageController {
    private Logger logger = LoggerFactory.getLogger(ImageController.class);
    private static final String SUCCESS = "SUCCESS";

    private ControllerUtil checkUtil = ControllerUtil.getInstance();
    private DateTimeUtil timeUtil = DateTimeUtil.getInstance();

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * Get Image By imageName
     */
    @RequestMapping(value = "/{imageName}", method = RequestMethod.GET)
    public ResultModel getImage(@PathVariable("imageName") @NotNull String imageName) {
        Image image = new Image()
                .setImageName(imageName)
                .setIsDeleted(0);

        List<Image> result = imageService.select(image);
        if (result.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片查询失败, imageName:" + imageName);
        }
        return new ResultModel(ResponseCode.OK, result.get(0));
    }

    /**
     * Get Image List By UserId
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public ResultModel getImageList(@PathVariable("userId") @NotNull String userId) {
        checkUtil.isFormatInt(userId);

        Image image = new Image()
                .setUserId(Integer.valueOf(userId))
                .setIsDeleted(0);

        List<Image> imageList = imageService.select(image);
        if (imageList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片查询失败, userId:" + userId);
        }
        return new ResultModel(ResponseCode.OK, imageList);
    }

    /**
     * Get Image Class By UserId And ClassId
     */
    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public ResultModel getImageClassList(@RequestParam @NotNull String userId,
                                         @RequestParam @NotNull String classId) {
        checkUtil.isFormatInt(userId);
        checkUtil.isFormatInt(classId);

        Image image = new Image()
                .setUserId(Integer.valueOf(userId))
                .setClassId(Integer.valueOf(classId))
                .setIsDeleted(0);

        List<Image> imageList = imageService.select(image);
        if (imageList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片查询失败, userId:" + userId + ", classId:" + classId);
        }
        return new ResultModel(ResponseCode.OK, imageList);
    }

    /**
     * Create Image
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postImage(@RequestParam @NotNull String userId,
                                 @RequestParam @NotNull String imageName,
                                 @RequestParam @NotNull String imageText) {
        checkUtil.isFormatInt(userId);

        String current = timeUtil.getCurrentTime();

        // TODO 将图片保存到磁盘
        String imagePath = "images/user/user.jpg";

        Image image = new Image()
                .setUserId(Integer.valueOf(userId))
                .setImageName(imageName)
                .setImageText(imageText)
                .setImagePath(imagePath)
                .setCreateTime(current)
                .setUpdateTime(current)
                .setIsDeleted(0);

        Integer result = imageService.insert(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片创建失败:" + image);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update Image
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putImage(@RequestParam @NotNull String imageName,
                                @RequestParam @NotNull String imageText) {
        String current = timeUtil.getCurrentTime();

        Image image = new Image()
                .setImageName(imageName)
                .setImageText(imageText)
                .setUpdateTime(current);

        Integer result = imageService.update(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片更新失败:" + image);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Delete Image
     */
    @RequestMapping(value = "/{imageId}", method = RequestMethod.DELETE)
    public ResultModel deleteImage(@PathVariable @NotNull String imageId) {
        checkUtil.isFormatInt(imageId);

        String current = timeUtil.getCurrentTime();

        Image image = new Image()
                .setId(Integer.valueOf(imageId))
                .setUpdateTime(current)
                .setIsDeleted(1);

        Integer result = imageService.update(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片删除失败:" + imageId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

}

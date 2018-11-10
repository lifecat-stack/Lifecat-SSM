package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.Image;
import com.ten.service.*;

import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.List;

import static com.ten.util.ControllerCheckUtil.*;

/**
 * Image Controller
 *
 * @author wshten
 * @date 2018/11/10
 */
@RestController
@RequestMapping("/image/v1")
public class ImageController {
    private Logger logger = LoggerFactory.getLogger(ImageController.class);
    private static final String SUCCESS = "SUCCESS";

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
        Image image = imageService.readImageByText(imageName);
        if (image == null) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片查询失败, imageName:" + imageName);
        }
        return new ResultModel(ResponseCode.OK, image);
    }

    /**
     * Get Image List By UserId
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public ResultModel getImageList(@PathVariable("userId") @NotNull String userId) {
        checkRquestDataFormatInt(userId);
        List<Image> imageList = imageService.readImageListByUserId(Integer.parseInt(userId));
        if (imageList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片查询失败, userId:" + userId);
        }
        return new ResultModel(ResponseCode.OK, imageList);
    }

    /**
     * Get Image Class By UserId And ClassId
     */
    @RequestMapping(value = "/class/{userId}/{classId}", method = RequestMethod.GET)
    public ResultModel getImageClassList(@PathVariable("userId") @NotNull String userId,
                                         @PathVariable("classId") @NotNull String classId) {
        checkRquestDataFormatInt(userId);
        checkRquestDataFormatInt(classId);
        int userid = Integer.parseInt(userId);
        int classid = Integer.parseInt(classId);
        List<Image> imageList = imageService.readImageListByClassId(userid, classid);
        if (imageList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片查询失败, userId:" + userId + ", classId:" + classId);
        }
        return new ResultModel(ResponseCode.OK, imageList);
    }

    /**
     * Create Image
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postImage(@RequestBody @NotNull Image image) {
        Integer result = imageService.createImage(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片创建失败:" + image);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update Image
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putImage(@RequestBody @NotNull Image image) {
        Integer result = imageService.updateImage(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片更新失败:" + image);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Delete Image
     */
    @RequestMapping(value = "/{diaryId}", method = RequestMethod.DELETE)
    public ResultModel deleteImage(@PathVariable @NotNull String diaryId) {
        checkRquestDataFormatInt(diaryId);
        Integer result = imageService.deleteImageById(Integer.parseInt(diaryId));
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片删除失败:" + diaryId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

}

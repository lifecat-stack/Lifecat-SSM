package com.ten.controller;

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
 * image rest
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/image/v1")
public class ImageController {

    private Logger logger = LoggerFactory.getLogger(ImageController.class);

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
        checkResourceNotNull(imageService, "imageService not load");
    }

    /**
     * 查询image
     *
     * @param imageName image_name
     */
    @RequestMapping(value = "/{imageName}", method = RequestMethod.GET, produces = "application/json")
    public Image getImage(@PathVariable("imageName") @NotNull String imageName) {
        // check
        checkRequestDataNotNull(imageName);
        // execute
        Image image = imageService.readImageByText(imageName);
        // return
        checkResourceNotNull(image, imageName + " not found");
        return image;
    }

    /**
     * 查询image list
     *
     * @param userId user_id
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<Image> getImageList(@PathVariable("userId") @NotNull String userId) {
        // check
        checkRequestDataNotNull(userId);
        checkRquestDataFormatInt(userId);
        // execute
        int id = Integer.parseInt(userId);
        List<Image> imageList = imageService.readImageListByUserId(id);
        // return
        checkResourceNotNull(imageList, userId + " image list is null");
        return imageList;
    }

    /**
     * 查询image list
     *
     * @param userId  user_id
     * @param classId class_id
     */
    @RequestMapping(value = "/class/{userId}/{classId}", method = RequestMethod.GET, produces = "application/json")
    public List<Image> getImageClassList(@PathVariable("userId") @NotNull String userId,
                                         @PathVariable("classId") @NotNull String classId) {
        // check
        checkRequestDataNotNull(userId);
        checkRequestDataNotNull(classId);
        checkRquestDataFormatInt(userId);
        checkRquestDataFormatInt(classId);
        // execute
        int userid = Integer.parseInt(userId);
        int classid = Integer.parseInt(classId);
        List<Image> imageList = imageService.readImageListByClassId(userid, classid);
        // return
        checkResourceNotNull(imageList, "userid:" + userId + ",classid:" + classId + " image list is null");
        return imageList;
    }

    /**
     * 创建image
     *
     * @param image image
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postImage(@RequestBody @NotNull Image image) {
        // check
        checkRequestDataNotNull(image);
        // execute
        int result = imageService.createImage(image);
        // return
        checkExecuteResultSuccess(result);
        return new ResultModel("image create success");
    }

    /**
     * 更新image
     *
     * @param image image
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putImage(@RequestBody @NotNull Image image) {
        // check
        checkRequestDataNotNull(image);
        // execute
        int result = imageService.updateImage(image);
        // return
        checkExecuteResultSuccess(result);
        return new ResultModel("image update success");
    }

    /**
     * 删除image
     *
     * @param diaryId diary_id
     */
    @RequestMapping(value = "/{diaryId}", method = RequestMethod.DELETE)
    public ResultModel deleteImage(@PathVariable @NotNull String diaryId) {
        // check
        checkRequestDataNotNull(diaryId);
        checkRquestDataFormatInt(diaryId);
        // execute
        int id = Integer.parseInt(diaryId);
        int result = imageService.deleteImageById(id);
        // return
        checkExecuteResultSuccess(result);
        return new ResultModel("image delete success");
    }

    /**
     * TODO :对image进行分类
     *
     * @param imageId image_id
     */
    @RequestMapping(value = "/classify/{imageId}", method = RequestMethod.GET)
    public ResultModel classifyImage(@PathVariable @NotNull String imageId) {
        // check
        checkRequestDataNotNull(imageId);
        checkRquestDataFormatInt(imageId);
        // execute
        // TODO 调用分类程序
        // return
        return new ResultModel("looking forward to classify...");
    }
}

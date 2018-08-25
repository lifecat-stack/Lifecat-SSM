package com.ten.controller;

import com.ten.entity.ImageDO;
import com.ten.dto.ResponseResult;
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
    public ImageDO getImage(@PathVariable("imageName") @NotNull String imageName) {
        // check
        checkRequestDataNotNull(imageName);
        // execute
        ImageDO imageDO = imageService.readImageByText(imageName);
        // return
        checkResourceNotNull(imageDO, imageName + " not found");
        return imageDO;
    }

    /**
     * 查询image list
     *
     * @param userId user_id
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<ImageDO> getImageList(@PathVariable("userId") @NotNull String userId) {
        // check
        checkRequestDataNotNull(userId);
        checkRquestDataFormatInt(userId);
        // execute
        int id = Integer.parseInt(userId);
        List<ImageDO> imageList = imageService.readImageListByUserId(id);
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
    public List<ImageDO> getImageClassList(@PathVariable("userId") @NotNull String userId,
                                           @PathVariable("classId") @NotNull String classId) {
        // check
        checkRequestDataNotNull(userId);
        checkRequestDataNotNull(classId);
        checkRquestDataFormatInt(userId);
        checkRquestDataFormatInt(classId);
        // execute
        int userid = Integer.parseInt(userId);
        int classid = Integer.parseInt(classId);
        List<ImageDO> imageList = imageService.readImageListByClassId(userid, classid);
        // return
        checkResourceNotNull(imageList, "userid:" + userId + ",classid:" + classId + " image list is null");
        return imageList;
    }

    /**
     * 创建image
     *
     * @param imageDO image
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseResult postImage(@RequestBody @NotNull ImageDO imageDO) {
        // check
        checkRequestDataNotNull(imageDO);
        // execute
        int result = imageService.createImage(imageDO);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult("image create success");
    }

    /**
     * 更新image
     *
     * @param imageDO image
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseResult putImage(@RequestBody @NotNull ImageDO imageDO) {
        // check
        checkRequestDataNotNull(imageDO);
        // execute
        int result = imageService.updateImage(imageDO);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult("image update success");
    }

    /**
     * 删除image
     *
     * @param diaryId diary_id
     */
    @RequestMapping(value = "/{diaryId}", method = RequestMethod.DELETE)
    public ResponseResult deleteImage(@PathVariable @NotNull String diaryId) {
        // check
        checkRequestDataNotNull(diaryId);
        checkRquestDataFormatInt(diaryId);
        // execute
        int id = Integer.parseInt(diaryId);
        int result = imageService.deleteImageById(id);
        // return
        checkExecuteResultSuccess(result);
        return new ResponseResult("image delete success");
    }

    /**
     * TODO :对image进行分类
     *
     * @param imageId image_id
     */
    @RequestMapping(value = "/classify/{imageId}", method = RequestMethod.GET)
    public ResponseResult classifyImage(@PathVariable @NotNull String imageId) {
        // check
        checkRequestDataNotNull(imageId);
        checkRquestDataFormatInt(imageId);
        // execute
        // TODO 调用分类程序
        // return
        return new ResponseResult("looking forward to classify...");
    }
}

package com.spring.controller;

import com.spring.entity.ImageDO;
import com.spring.exception.ImageNotFoundException;
import com.spring.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.List;

@Controller
@RequestMapping("/image/v1")
public class ImageController {

    private static Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imageService;

    @ResponseBody
    @RequestMapping(value = "/{imageName}", method = RequestMethod.GET, produces = "application/json")
    public ImageDO getImage(@PathVariable("imageName") String imageName) {
        ImageDO imageDO = imageService.readImageByText(imageName);
        if (imageDO == null) {
            throw new ImageNotFoundException(imageName);
        }
        return imageDO;
    }

    @ResponseBody
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<ImageDO> getImageList(@PathVariable("userId") String userId) {
        int id = Integer.parseInt(userId);
        List<ImageDO> imageList = imageService.readImageListByUserId(id);
        if (imageList == null) {
            throw new ImageNotFoundException(id);
        }
        return imageList;
    }

    @ResponseBody
    @RequestMapping(value = "/class/{userId}/{classId}", method = RequestMethod.GET, produces = "application/json")
    public List<ImageDO> getImageClassList(@PathVariable("userId") String userId,
                                           @PathVariable("classId") String classId) {
        int userid = Integer.parseInt(userId);
        int classid = Integer.parseInt(classId);
        List<ImageDO> imageList = imageService.readImageListByClassId(userid, classid);
        if (imageList == null) {
            throw new ImageNotFoundException(userid, classid);
        }
        return imageList;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postImage() {
        // TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String putImage() {
        // TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteImage() {
        // TODO
        return null;
    }

    @RequestMapping(value = "/classify", method = RequestMethod.POST)
    public String classifyImage() {
        // TODO
        return null;
    }
}

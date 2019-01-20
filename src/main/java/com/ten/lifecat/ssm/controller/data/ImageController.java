package com.ten.lifecat.ssm.controller.data;

import com.ten.lifecat.ssm.dto.ResponseCode;
import com.ten.lifecat.ssm.dto.ResultModel;
import com.ten.lifecat.ssm.entity.Image;
import com.ten.lifecat.ssm.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController extends BaseController<Image> {
    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public ResultModel list(Image image) {
        image.setIsDeleted(0);

        List<Image> imageList = imageService.select(image);
        if (imageList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片列表查询失败" + image);
        }
        return new ResultModel(ResponseCode.OK, imageList);
    }

    @Override
    public ResultModel get(Image image) {
        image.setIsDeleted(0);

        List<Image> imageList = imageService.select(image);
        if (imageList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片查询失败" + image);
        }
        return new ResultModel(ResponseCode.OK, imageList.get(0));
    }

    @Override
    public ResultModel post(Image image) {
        String current = super.dateTimeUtil.getCurrentTime();

        // TODO 将图片保存到磁盘
        String imagePath = "images/user/user.jpg";

        image.setImagePath(imagePath)
                .setCreateTime(current)
                .setUpdateTime(current)
                .setIsDeleted(0);

        Integer result = imageService.insert(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片创建失败:" + image);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel update(Image image) {
        String current = super.dateTimeUtil.getCurrentTime();

        image.setUpdateTime(current);

        Integer result = imageService.update(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片更新失败:" + image);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel delete(Image image) {
        String current = super.dateTimeUtil.getCurrentTime();

        image.setUpdateTime(current)
                .setIsDeleted(1);

        Integer result = imageService.update(image);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "图片删除失败:" + image);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }
}

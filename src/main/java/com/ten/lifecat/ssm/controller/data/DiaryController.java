package com.ten.lifecat.ssm.controller.data;

import com.ten.lifecat.ssm.dto.ResponseCode;
import com.ten.lifecat.ssm.dto.ResultModel;
import com.ten.lifecat.ssm.entity.Diary;
import com.ten.lifecat.ssm.service.DiaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController extends BaseController<Diary> {
    private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Override
    public ResultModel list(Diary diary) {
        diary.setIsDeleted(0);

        List<Diary> result = diaryService.select(diary);
        if (result.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记列表查询失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, result);
    }

    @Override
    public ResultModel get(@RequestBody Diary diary) {
        diary.setIsDeleted(0);

        List<Diary> result = diaryService.select(diary);
        if (result.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记查询失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, result.get(0));
    }

    @Override
    public ResultModel post(@RequestBody Diary diary) {
        String current = super.dateTimeUtil.getCurrentTime();

        diary.setCreateTime(current);
        diary.setUpdateTime(current);
        diary.setIsDeleted(0);

        Integer result = diaryService.insert(diary);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记创建失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel update(@RequestBody Diary diary) {
        String current = super.dateTimeUtil.getCurrentTime();

        diary.setUpdateTime(current);

        Integer result = diaryService.update(diary);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记更新失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    @Override
    public ResultModel delete(@RequestBody Diary diary) {
        String current = super.dateTimeUtil.getCurrentTime();

        diary.setUpdateTime(current);
        diary.setIsDeleted(1);

        Integer result = diaryService.update(diary);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记删除失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }
}

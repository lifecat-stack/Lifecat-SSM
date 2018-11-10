package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.Diary;
import com.ten.service.*;

import com.sun.istack.internal.NotNull;
import com.ten.util.ControllerUtil;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Diary Controller
 *
 * @author wshten
 * @date 2018/11/10
 */
@RestController
@RequestMapping("/diary/v1")
public class DiaryController {
    private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);
    private static final String SUCCESS = "SUCCESS";

    private ControllerUtil checkUtil = ControllerUtil.getInstance();
    private DateTimeUtil timeUtil = DateTimeUtil.getInstance();

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    /**
     * Get All Diary By UserId
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public ResultModel getDiaryList(@PathVariable("userId") @NotNull String userId) {
        checkUtil.isFormatInt(userId);

        Diary diary = new Diary()
                .setUserId(Integer.valueOf(userId))
                .setIsDeleted(0);

        List<Diary> diaryList = diaryService.select(diary);
        if (diaryList.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记查询失败, userId:" + userId);
        }
        return new ResultModel(ResponseCode.OK, diaryList);
    }

    /**
     * Get Diary By diaryName
     */
    @RequestMapping(value = "/{diaryName}", method = RequestMethod.GET)
    public ResultModel getDiary(@PathVariable("diaryName") @NotNull String diaryName) {
        Diary diary = new Diary()
                .setDiaryName(diaryName)
                .setIsDeleted(0);

        List<Diary> result = diaryService.select(diary);
        if (result.size() < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记查询失败, diaryName:" + diaryName);
        }
        return new ResultModel(ResponseCode.OK, result.get(0));
    }

    /**
     * Create Diary
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postDiary(@RequestParam @NotNull String diaryName,
                                 @RequestParam @NotNull String diaryText,
                                 @RequestParam @NotNull String userId) {
        checkUtil.isFormatInt(userId);

        String current = timeUtil.getCurrentTime();

        Diary diary = new Diary()
                .setUserId(Integer.valueOf(userId))
                .setDiaryName(diaryName)
                .setdiaryText(diaryText)
                .setCreateTime(current)
                .setUpdateTime(current)
                .setIsDeleted(0);

        Integer result = diaryService.insert(diary);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记创建失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update Diary
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putDiary(@RequestParam @NotNull String diaryName,
                                @RequestParam @NotNull String diaryText) {
        String current = timeUtil.getCurrentTime();

        Diary diary = new Diary()
                .setDiaryName(diaryName)
                .setdiaryText(diaryText)
                .setUpdateTime(current);

        Integer result = diaryService.update(diary);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记更新失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Delete Diary By diaryId
     */
    @RequestMapping(value = "/{diaryId}", method = RequestMethod.DELETE)
    public ResultModel deleteDiary(@PathVariable("diaryId") @NotNull String diaryId) {
        checkUtil.isFormatInt(diaryId);

        String current = timeUtil.getCurrentTime();

        Diary diary = new Diary()
                .setId(Integer.valueOf(diaryId))
                .setUpdateTime(current)
                .setIsDeleted(1);

        Integer result = diaryService.update(diary);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记删除失败:" + diaryId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

}

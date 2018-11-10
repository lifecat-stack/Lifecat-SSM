package com.ten.controller;

import com.ten.dto.ResponseCode;
import com.ten.dto.ResultModel;
import com.ten.entity.Diary;
import com.ten.service.*;

import com.sun.istack.internal.NotNull;
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
        checkFormatIsInt(userId);
        List<Diary> diaryList = diaryService.readDiaryListByUserId(Integer.parseInt(userId));
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
        Diary diary = diaryService.readDiaryByDiaryName(diaryName);
        if (diary == null) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记查询失败, diaryName:" + diaryName);
        }
        return new ResultModel(ResponseCode.OK, diary);
    }

    /**
     * Create Diary
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultModel postDiary(@RequestBody @NotNull Diary diary) {
        Integer result = diaryService.createDiary(diary);
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记创建失败:" + diary);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

    /**
     * Update Diary
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultModel putDiary(@RequestBody @NotNull Diary diary) {
        Integer result = diaryService.updateDiary(diary);
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
        checkFormatIsInt(diaryId);
        Integer result = diaryService.deleteDiaryById(Integer.parseInt(diaryId));
        if (result < 1) {
            return new ResultModel(ResponseCode.SERVER_ERROR, "日记删除失败:" + diaryId);
        }
        return new ResultModel(ResponseCode.OK, SUCCESS);
    }

}

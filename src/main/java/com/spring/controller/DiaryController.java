package com.spring.controller;

import com.spring.entity.DiaryDO;
import com.spring.exception.RequestSuccess;
import com.spring.service.*;

import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.spring.util.ControllerCheckUtil.*;

@RestController
@RequestMapping("/diary/v1")
public class DiaryController {

    private Logger logger = LoggerFactory.getLogger(DiaryController.class);

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
        checkResourceNotNull(diaryService, "diaryService not load");
    }

    /**
     * 查询diary list
     *
     * @param userId user_id
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<DiaryDO> getDiaryList(@PathVariable("userId") @NotNull String userId) {
        // check
        checkRquestDataFormatInt(userId);
        // execute
        int id = Integer.parseInt(userId);
        List<DiaryDO> diaryList = diaryService.readDiaryListByUserId(id);
        // return
        checkResourceNotNull(diaryList, userId + " diary list is null");
        return diaryList;
    }

    /**
     * 查询diary
     *
     * @param diaryName diary_name
     */
    @RequestMapping(value = "/{diaryName}", method = RequestMethod.GET, produces = "application/json")
    public DiaryDO getDiary(@PathVariable("diaryName") @NotNull String diaryName) {
        // check
        checkRequestDataNotNull(diaryName);
        // execute
        DiaryDO diary = diaryService.readDiaryByDiaryName(diaryName);
        // return
        checkResourceNotNull(diary, diaryName + " not found");
        return diary;
    }

    /**
     * 创建diary
     *
     * @param diaryDO diary
     */
    @RequestMapping(method = RequestMethod.POST)
    public RequestSuccess postDiary(@RequestBody @NotNull DiaryDO diaryDO) {
        // check
        checkRequestDataNotNull(diaryDO);
        // execute
        int result = diaryService.createDiary(diaryDO);
        // return
        checkExecuteResultSuccess(result);
        return new RequestSuccess("diary create success");
    }

    /**
     * 更新diary
     *
     * @param diaryDO diary
     */
    @RequestMapping(method = RequestMethod.PUT)
    public RequestSuccess putDiary(@RequestBody @NotNull DiaryDO diaryDO) {
        // check
        checkRequestDataNotNull(diaryDO);
        // execute
        int result = diaryService.updateDiary(diaryDO);
        // return
        checkExecuteResultSuccess(result);
        return new RequestSuccess("diary update success");
    }

    /**
     * 删除diary
     *
     * @param diaryId diary_id
     */
    @RequestMapping(value = "/{diaryId}", method = RequestMethod.DELETE)
    public RequestSuccess deleteDiary(@PathVariable("diaryId") @NotNull String diaryId) {
        // check
        checkRequestDataNotNull(diaryId);
        checkRquestDataFormatInt(diaryId);
        // execute
        int id = Integer.parseInt(diaryId);
        int result = diaryService.deleteDiaryById(id);
        // return
        checkExecuteResultSuccess(result);
        return new RequestSuccess("diary delete success");
    }

}

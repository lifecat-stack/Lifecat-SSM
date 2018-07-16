package com.spring.controller;

import com.spring.entity.DiaryDO;
import com.spring.entity.UserDO;
import com.spring.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * diary模块controller
 *
 * @version v1
 * @date 2018/7/13
 * @auther ten
 */
@Controller
@RequestMapping("/diary/v1")
public class DiaryController {

    private Logger logger = LoggerFactory.getLogger(DiaryController.class);

    @Autowired
    private DiaryQueryService diaryQueryService;
    @Autowired
    private DiaryListQueryService diaryListQueryService;
    @Autowired
    private DiaryUploadService diaryUploadService;
    @Autowired
    private DiaryUpdateService diaryUpdateService;
    @Autowired
    private DiaryDeleteService diaryDeleteService;

    /**
     * get 'diary' by diaryId
     */
    @ResponseBody
    @RequestMapping(value = "/diary/{diaryId}", method = RequestMethod.GET)
    public DiaryDO diaryQuery(@PathVariable("diaryId") String diaryId) {
        logger.info("diary get diaryId is:" + diaryId);
        assert diaryId != null;
        return diaryQueryService.queryDiaryByDiaryId(Integer.parseInt(diaryId));
    }

    /**
     * get 'diary list' by userId
     */
    @ResponseBody
    @RequestMapping(value = "/diaries/{userId}", method = RequestMethod.GET)
    public List<DiaryDO> diariesQuery(@PathVariable("userId") String userId) {
        logger.info("diaries get userId is:" + userId);
        assert userId != null;
        return diaryListQueryService.queryDiaryListByUserId(Integer.parseInt(userId));
    }

    /**
     * post 'diary' to database
     */
    @RequestMapping(value = "/diary", method = RequestMethod.POST)
    public String diaryUpload(@RequestParam("diaryName") String diaryName,
                              @RequestParam("diaryText") String diaryText,
                              @RequestParam("userId") String userId) {
        logger.info("diary post");
        assert diaryName != null;
        assert diaryText != null;
        assert userId != null;
        diaryUploadService.uploadDiary(diaryName, diaryText, userId);
        return "home";
    }

    /**
     * delete 'diary' from database by diaryId
     */
    @ResponseBody
    @RequestMapping(value = "/diary/{diaryId}", method = RequestMethod.DELETE)
    public String diaryDelete(@PathVariable("diaryId") String diaryId) {
        logger.info("diary delete");
        assert diaryId != null;
        diaryDeleteService.deleteDiary(Integer.parseInt(diaryId));
        return "delete success";
    }

    /**
     * put 'diary' to database by diary param
     */
    @RequestMapping(value = "/diary", method = RequestMethod.PUT)
    public void diaryUpdate(@RequestParam("id") String diaryId,
                            @RequestParam("name") String diaryName,
                            @RequestParam("text") String diaryText) {
        logger.info("diary put");
        assert diaryId != null;
        assert diaryName != null;
        assert diaryText != null;

    }
}

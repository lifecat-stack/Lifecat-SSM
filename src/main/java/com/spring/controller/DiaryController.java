package com.spring.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spring.entity.DiaryDO;
import com.spring.entity.UserDO;
import com.spring.handler.DiaryNotFoundExceptionHandler;
import com.spring.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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
    private DiaryService diaryService;

    /**
     * get 'diary' by diaryId
     */
    @ResponseBody
    @RequestMapping(value = "/diary/{diaryId}", method = RequestMethod.GET)
    public DiaryDO diaryQuery(@PathVariable("diaryId") String diaryId) {
        logger.debug("diary get diaryId is:" + diaryId);
        assert diaryId != null;
        return diaryService.queryDiaryByDiaryId(Integer.parseInt(diaryId));
    }

    /**
     * get 'diary list' by userId
     */
    @ResponseBody
    @RequestMapping(value = "/diaries/{userId}", method = RequestMethod.GET)
    public List<DiaryDO> diariesQuery(@PathVariable("userId") String userId) {
        logger.debug("diaries get userId is:" + userId);
        assert userId != null;
        return diaryService.queryDiaryListByUserId(Integer.parseInt(userId));
    }

    /**
     * post 'diary' to database
     * <p>
     * TODO 获取POST数据
     */
    @RequestMapping(value = "/diary", method = RequestMethod.POST)
    public String diaryUpload(@RequestBody String param) {
        System.out.println(param);

        String diaryName = "name";
        String diaryText = "text";
        String userId = "1";
        logger.info("diary post" + diaryName + diaryText + userId);
//        assert diaryName != null;
//        assert diaryText != null;
//        assert userId != null;
        diaryService.uploadDiary(diaryName, diaryText, userId);
        return "home";
    }

    /**
     * delete 'diary' from database by diaryId
     */
    @ResponseBody
    @RequestMapping(value = "/diary/{diaryId}", method = RequestMethod.DELETE)
    public String diaryDelete(@PathVariable("diaryId") String diaryId) {
        logger.debug("diary delete");
        assert diaryId != null;
        diaryService.deleteDiary(Integer.parseInt(diaryId));
        return "delete success";
    }

    /**
     * put 'diary' to database by diary param
     */
    @RequestMapping(value = "/diary", method = RequestMethod.PUT)
    public void diaryUpdate(@RequestParam("id") String diaryId,
                            @RequestParam("name") String diaryName,
                            @RequestParam("text") String diaryText) {
        logger.debug("diary put");
        assert diaryId != null;
        assert diaryName != null;
        assert diaryText != null;

    }

//
//    @ExceptionHandler(DiaryNotFoundExceptionHandler.class)
//    public String handleDiaryNotFound(){
//
//    }
}

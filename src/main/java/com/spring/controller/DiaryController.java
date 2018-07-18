package com.spring.controller;

import com.spring.entity.DiaryDO;
import com.spring.exception.DiaryNotFoundException;
import com.spring.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/diary/v1")
public class DiaryController {

    private Logger logger = LoggerFactory.getLogger(DiaryController.class);

    @Autowired
    private DiaryService diaryService;

    @ResponseBody
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<DiaryDO> getDiaryList(@PathVariable("userId") String userId) {
        int id = Integer.parseInt(userId);
        List<DiaryDO> diaryList = diaryService.readDiaryListByUserId(id);
        if (diaryList == null) {
            throw new DiaryNotFoundException(id);
        }
        return diaryList;
    }

    @ResponseBody
    @RequestMapping(value = "/{diaryName}", method = RequestMethod.GET, produces = "application/json")
    public DiaryDO getDiary(@PathVariable("diaryName") String diaryName) {
        DiaryDO diary = diaryService.readDiaryByDiaryName(diaryName);
        if (diary == null) {
            throw new DiaryNotFoundException(diaryName);
        }
        return diary;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postDiary(@RequestBody String param) {
        System.out.println(param);

        String diaryName = "name";
        String diaryText = "text";
        String userId = "1";
        logger.info("diary post" + diaryName + diaryText + userId);
//        assert diaryName != null;
//        assert diaryText != null;
//        assert userId != null;
//        diaryService.createDiary(diaryName, diaryText, userId);
        return "home";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putDiary() {
    }

    @ResponseBody
    @RequestMapping(value = "/{diaryId}", method = RequestMethod.DELETE)
    public String deleteDiary(@PathVariable("diaryId") String diaryId) {
        return null;
    }
}

package com.spring.controller;

import com.spring.entity.UserDO;
import com.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/diary")
public class DiaryController {
    @Autowired
    private DiaryListQueryService diaryListQueryService;
    @Autowired
    private DiaryUploadService diaryUploadService;
    @Autowired
    private DiaryUpdateService diaryUpdateService;
    @Autowired
    private DiaryDeleteService diaryDeleteService;

    @RequestMapping("/diary_upload")
    public ModelAndView diaryUpload(@RequestParam("diaryName") String diaryName,
                                    @RequestParam("diaryText") String diaryText,
                                    @ModelAttribute("user") UserDO userDO) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/diary_delete")
    public ModelAndView diaryDelete(String diaryId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/diary_all_delete")
    public ModelAndView diaryAllDelete(@ModelAttribute("user") UserDO userDO) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/diary_update")
    public ModelAndView diaryUpdate(String diaryId, String diaryName, String diaryText) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/diary_list_query")
    public ModelAndView diaryListQuery(@ModelAttribute("user") UserDO userDO) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}

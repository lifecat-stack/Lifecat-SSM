package com.spring.controller;

import com.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/image/v1")
public class ImageController {
    @Autowired
    private ImageQueryService imageQueryService;
    @Autowired
    private ImageListQueryService imageListQueryService;
    @Autowired
    private ImageClassQueryService imageClassQueryService;
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private ImageDeleteService imageDeleteService;
    @Autowired
    private ImageTextUpdateService imageTextUpdateService;
    @Autowired
    private ImageClassifyService imageClassifyService;

    @RequestMapping("/image_query")
    public ModelAndView imageQuery() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/image_list_query")
    public ModelAndView imageListQuery() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/image_class_query")
    public ModelAndView imageClassQuery() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/image_upload")
    public ModelAndView imageUpload() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/image_delete")
    public ModelAndView imageDelete() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/image_text_update")
    public ModelAndView imageTextUpdate() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/image_classify")
    public ModelAndView imageClassify() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}

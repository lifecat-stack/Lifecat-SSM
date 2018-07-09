package com.spring.controller;

import com.spring.entity.BookDO;
import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("listBooks")
    public ModelAndView listBooks(){
        ModelAndView mav = new ModelAndView();
        List<BookDO> cs= bookService.listBooks();

        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listBooks");
        return mav;
    }
}

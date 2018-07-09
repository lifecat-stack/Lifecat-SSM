package com.spring.service.impl;

import com.spring.entity.BookDO;
import com.spring.mapper.BookMapper;
import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDO> listBooks() {
        return bookMapper.queryBooks();
    }
}

package com.spring.mapper;

import com.spring.entity.BookDO;

import java.util.List;

public interface BookMapper {
    public List<BookDO> queryBooks();
}

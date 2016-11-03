package com.shuoshu.core.book.model;

import com.shuoshu.core.book.entity.Book;

/**
 * Created by mutou on 2016/8/28.
 */
public class BookModel extends Book{

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

package com.shuoshu.core.book.service;

import com.shuoshu.core.book.entity.Book;
import com.shuoshu.core.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mutou on 2016/11/2.
 */
@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getBookListByPage(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}

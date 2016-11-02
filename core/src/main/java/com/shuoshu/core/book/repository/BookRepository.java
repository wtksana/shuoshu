package com.shuoshu.core.book.repository;

import com.shuoshu.core.book.entity.Book;
import com.shuoshu.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by mutou on 2016/11/2.
 */
public interface BookRepository extends JpaSpecificationExecutor<Book>, PagingAndSortingRepository<Book, Serializable> {

}

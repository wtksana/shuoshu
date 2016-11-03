package com.shuoshu.core.book.repository;

import com.shuoshu.core.book.entity.Book;
import com.shuoshu.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by mutou on 2016/11/2.
 */
@Repository(value = "bookRepository")
public interface BookRepository extends JpaSpecificationExecutor<Book>, PagingAndSortingRepository<Book, Serializable> {

}

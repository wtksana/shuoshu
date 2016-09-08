package com.shuoshu.core.user.repository;

import com.shuoshu.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mutou on 2016/8/31.
 */
public interface UserRepository extends JpaSpecificationExecutor<User>, PagingAndSortingRepository<User, Serializable> {

    //接口以外的方法补充
    //http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#dependencies.spring-boot
    //上述此地址可以找到命名规则


    //通过用户名查找用户
    User findByUserName(String userName);

    //通过用户手机号码查找用户
    User findByMobile(String mobile);

    //通过手机号和用户名
    User findByUserNameAndMobile(String userName, String mobile);

    //如果觉得查询条件太多，可以通过sql查询
    /*@Query(value = "select u from User u where u.uuid =?1")
    List<User> findBySql(String uuid);*/
}

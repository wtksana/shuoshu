package com.shuoshu.core.user.service;

import com.shuoshu.core.user.entity.User;
import com.shuoshu.core.user.repository.UserRepository;
import com.shuoshu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by mutou on 2016/8/31.
 */
@Component
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public List<User> getUserList(){
        return (List<User>) userRepository.findAll();
    }

    public Page<User> getUserListByPage(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    /*public User getUserByUUID(String uuid){
        return userRepository.findBySql(uuid);
    }*/

    //更加复杂的查询
    /*public Page<User> getUserListByModel(final User user, Pageable pageable){
        userRepository.findAll(new Specification<User>(

        ) {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate userNamePre = null;
                if (StringUtils.isNotBlank(user.getUserName())){
                    userNamePre = criteriaBuilder.equal(root.<String> get("userName"), user.getUserName());
                }
                if(userNamePre != null){
                    criteriaQuery.where(userNamePre);
                }
                return null;
            }
        }, pageable);
                return null;
    }*/
}

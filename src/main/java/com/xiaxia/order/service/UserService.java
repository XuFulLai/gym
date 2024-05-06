package com.xiaxia.order.service;

import com.xiaxia.order.domain.User;

/**
 * @author xiaxia
 * @date 2024/5/5 17:19
 */
public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User getUserByName(String name);

    boolean checkPassword(String password, String password1);
}

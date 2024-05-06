package com.xiaxia.order.mapper;

import com.xiaxia.order.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xufulai
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-05-05 17:18:42
* @Entity com.xiaxia.order.domain.User
*/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByName(String name);
}

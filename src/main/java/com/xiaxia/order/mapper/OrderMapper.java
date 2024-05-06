package com.xiaxia.order.mapper;

import com.xiaxia.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author xufulai
* @description 针对表【order】的数据库操作Mapper
* @createDate 2024-04-20 22:27:42
* @Entity xiaxia.order.domain.Order
*/
@Mapper
public interface OrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> list(Order record);

    List<Order> getUserOrders(Integer id);
}

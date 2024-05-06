package com.xiaxia.order.service;

import com.xiaxia.order.domain.Order;

import java.util.List;

/**

 * @date 2024/4/20 22:28
 */
public interface OrderService {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> list(Order record);

    List<Order> getUserOrders(Integer id);
}

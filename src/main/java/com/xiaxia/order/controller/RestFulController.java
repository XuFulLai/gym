package com.xiaxia.order.controller;

import com.xiaxia.order.domain.Order;
import com.xiaxia.order.domain.User;
import com.xiaxia.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author xiaxia
 * @date 2024/5/6 0:33
 */
@RestController
public class RestFulController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询当前用户订单
     */
    @RequestMapping("/userOrders")
    public List<Order> getUserOrders(HttpServletRequest request) {
        // 获取Session
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 获取当前登录用户信息
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
                // 查询当前登录用户的订单
                List<Order> userOrders = orderService.getUserOrders(loggedInUser.getId());
                return userOrders;
            }
        }
        // 返回空列表或者其他错误信息，根据实际情况处理
        return Collections.emptyList();
    }
}

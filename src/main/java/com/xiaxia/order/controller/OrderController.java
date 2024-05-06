package com.xiaxia.order.controller;

import com.xiaxia.order.domain.Order;
import com.xiaxia.order.domain.User;
import com.xiaxia.order.domain.vo.payReq;
import com.xiaxia.order.domain.vo.OrderReq;
import com.xiaxia.order.domain.vo.OrderResp;
import com.xiaxia.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @date 2024/4/20 22:28
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单列表
     *
     * @param req
     * @return
     */
    @PostMapping("list")
    public OrderResp list(@RequestBody OrderReq req) {
        OrderResp resp = new OrderResp();
        // 查询订单列表
        try {
            Order order = new Order();
            order.setOrderNo(req.getorderNo());
            order.setOrderStatus(req.getOrderStatus());
            List<Order> list = orderService.list(order);
            resp.setList(list);
            resp.setCode(200);
            resp.setMsg("查询成功");
            return resp;
        } catch (Exception e) {
            resp.setCode(-1);
            resp.setMsg("查询失败");
            return resp;
        }
    }

    @PostMapping("/pay")
    public String makePayment(HttpServletRequest request, @RequestBody payReq payReq) {
        // 获取Session
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 获取当前登录用户信息
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
                // 在这里使用 loggedInUser 执行你的支付逻辑
                // 例如，检查用户余额，更新订单状态等等
                payReq.getpayList().forEach(item -> {
                    Order order = new Order();
                    order.setUserId(loggedInUser.getId());
                    order.setOrderNo(UUID.randomUUID().toString());
                    order.setOrderStatus("paid");
                    order.setSportName(item.getSportName());
                    order.setOrderTime(new Date());
                    order.setMoney(item.getPrice());
                    order.setCourt(item.getVuenue());
                    orderService.insert(order);
                });
                return "BookSuccess";
            }
        }
        return "redirect:/login";
    }
}

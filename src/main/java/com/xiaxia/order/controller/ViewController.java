package com.xiaxia.order.controller;

import com.xiaxia.order.domain.Order;
import com.xiaxia.order.domain.RegistrationForm;
import com.xiaxia.order.domain.User;
import com.xiaxia.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author xiaxia
 * @date 2024/5/4 20:55
 */
@Controller
public class ViewController {

    //跳转到Basketball
    @GetMapping("Basketball")
    public String basketball() {
        return "Basketball";
    }

    //羽毛球
    @GetMapping("badminton")
    public String badminton() {
        return "badminton";
    }

    //乒乓球
    @GetMapping("PingPang")
    public String pingPang() {
        return "PingPang";
    }

    //网球
    @GetMapping("tennis")
    public String tennis() {
        return "tennis";
    }

    //武术
    @GetMapping("WuShu")
    public String WuShu() {
        return "WuShu";
    }

    //体育馆
    @GetMapping("gym")
    public String gym() {
        return "gym";
    }

    //注册
    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    //登录
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/userLogin")
    public String userLogin() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "Basketball";
    }

    @GetMapping("loginFailure")
    private String loginFail(Model model) {
        model.addAttribute("error", "用户名或密码错误");
        return "loginFailure";
    }


    @GetMapping("loginSuccess")
    private String loginSuccess(Model model) {
        model.addAttribute("message", "登录成功");
        return "loginSuccess";
    }

    //订单页面
    @GetMapping("orderList")
    public String order(Model model) {
        model.addAttribute("order", new Order());
        return "orderList";
    }

    @Autowired
    private OrderService orderService;

    @GetMapping("/userOrdersPage")
    public String getUserOrdersPage(HttpServletRequest request, Model model) {
        List<Order> userOrders = null;
        // 获取Session
        HttpSession session = request.getSession(false);
        // 获取当前登录用户的订单数据
        if (session != null) {
            // 获取当前登录用户信息
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
                // 查询当前登录用户的订单
                userOrders = orderService.getUserOrders(loggedInUser.getId());
            }
        }

        // 将订单数据传递给模板
        model.addAttribute("userOrders", userOrders);

        // 返回Thymeleaf模板文件名
        return "orderlist";
    }

    //管理员登录页面
    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "adminLogin";
    }

}

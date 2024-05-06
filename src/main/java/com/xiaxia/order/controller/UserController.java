package com.xiaxia.order.controller;

import com.xiaxia.order.domain.RegistrationForm;
import com.xiaxia.order.domain.User;
import com.xiaxia.order.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    public String userLogin(@ModelAttribute("user") User user, HttpSession session) {
        // 处理用户登录逻辑
        User loginUser = userService.getUserByName(user.getUsername());
        if (loginUser == null) {
            return "loginFailure";
        } else {
            // 验证密码是否正确
            if (userService.checkPassword(user.getPassword(), loginUser.getPassword())) {
                // 登录成功，将用户信息存储到session中
                session.setAttribute("loggedInUser", loginUser);
                return "redirect:/index";
            } else {
                return "loginFailure";
            }
        }
    }



    /**
     * 用户注册
     */
    @PostMapping("/submit-registration")
    public String submitRegistration(@ModelAttribute("registrationForm") RegistrationForm registrationForm) {
        User user = userService.getUserByName(registrationForm.getUsername());
        if (user != null) {
            return "redirect:/register?error=true";
        }else {
            User user1 = new User();
            BeanUtils.copyProperties(registrationForm, user1);
            userService.insert(user1);
            return "redirect:/login";
        }
    }

    @PostMapping("/submit-admin-login")
    public String submitAdminLogin(@ModelAttribute("user") User user, HttpSession session) {
        // 处理用户登录逻辑
        User loginUser = userService.getUserByName(user.getUsername());
        if (loginUser == null) {
            return "loginFailure";
        } else {
            // 验证密码是否正确
            if (userService.checkPassword(user.getPassword(), loginUser.getPassword())) {
                // 登录成功，将用户信息存储到session中
                session.setAttribute("loggedInUser", loginUser);
                return "redirect:/index";
            } else {
                return "loginFailure";
            }
        }
    }

}

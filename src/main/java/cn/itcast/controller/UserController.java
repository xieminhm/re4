package cn.itcast.controller;

import cn.itcast.daomain.Role;
import cn.itcast.daomain.User;
import cn.itcast.service.RoleService;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 用户管理
     */
    @RequestMapping("/findUserByRole")
    public ModelAndView findUserByRole() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.userFindAll();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("/pages/user-list.jsp");
        return modelAndView;
    }
    /**
     * 新建用户,返回复选框选项
     */
    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("/pages/user-add.jsp");
        return modelAndView;
    }

    /**
     * 保存用户
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(User user,Long[] roleIds) {
        ModelAndView modelAndView = new ModelAndView();
        userService.save(user,roleIds);
        modelAndView.setViewName("/user/findUserByRole");
        return modelAndView;
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView delete(int userId) {
        ModelAndView modelAndView = new ModelAndView();
        userService.delete(userId);
        modelAndView.setViewName("/user/findUserByRole");
        return modelAndView;
    }

}

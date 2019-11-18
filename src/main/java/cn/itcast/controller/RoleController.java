package cn.itcast.controller;

import cn.itcast.daomain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {

        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("/pages/role-list.jsp");
        return modelAndView;
    }

    /**
     * 增加角色
     *
     * @return
     */
    @RequestMapping("/saveRole")
    public ModelAndView saveRole(Role role) {
        ModelAndView modelAndView = new ModelAndView();
        roleService.saveRole(role);
        modelAndView.setViewName("/role/findAll");
        return modelAndView;
    }
}

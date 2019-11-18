package cn.itcast.service;

import cn.itcast.daomain.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有
     */
    List<Role> findAll();
    /**
     * 增加角色
     * @return
     */
    void saveRole(Role role);
}

package cn.itcast.dao;

import cn.itcast.daomain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有
     * @return
     */
    List<Role> findAll();

    /**
     * 用户管理,查询角色
     * @param id
     * @return
     */
    List<Role> findRoleUser(Long id);
    /**
     * 增加角色
     * @return
     */
    void saveRole(Role role);
}

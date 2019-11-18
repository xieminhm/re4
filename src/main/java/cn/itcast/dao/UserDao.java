package cn.itcast.dao;

import cn.itcast.daomain.User;

import java.util.List;

public interface UserDao {
    /*
    查询user数据
     */
    List<User> fandAllUserByRole();

    /**
     * 保存用户
     *
     * @param user
     */
    long save(User user);

    /**
     * 保存复选框中的角色信息
     *
     * @param userId
     */
    void saveUserRole(long userId, Long[] roleIds);

    //删除中间表
    void deleteRoleUser(int userId);
    //删除用户表
    void deleteRole(int userId);
}

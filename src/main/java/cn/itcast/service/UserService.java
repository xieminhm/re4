package cn.itcast.service;

import cn.itcast.daomain.User;

import java.util.List;

public interface UserService {
    /**
     * 查询user
     * @return
     */
    List<User> userFindAll();

    /**
     * 保存用户
     * @param user
     */

    void save(User user, Long[] roleIds);

    /**
     * 删除用户
     * @return
     */
    void delete(int userId);
}

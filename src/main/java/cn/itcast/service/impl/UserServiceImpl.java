package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.daomain.Role;
import cn.itcast.daomain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 用户管理,查询用户信息
     *
     * @return
     */
    @Override
    public List<User> userFindAll() {
        List<User> userList = userDao.fandAllUserByRole();
        for (User user : userList) {

            Long id = user.getId();

            List<Role> roleList = roleDao.findRoleUser(id);
            user.setRoles(roleList);

        }
        return userList;
    }

    /**
     * 保存用户
     *
     * @param user
     */
    @Override
    public void save(User user, Long[] roleIds) {
        long userId = userDao.save(user);
        //保存复选框中的角色
        userDao.saveUserRole(userId, roleIds);


    }

    /**
     * 删除用户
     *
     * @return
     */
    @Override
    public void delete(int userId) {
        //先删除中间表
        userDao.deleteRoleUser(userId);
        //删除用户表
       userDao.deleteRole(userId);
    }
}

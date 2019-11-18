package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.daomain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    /**
     * 查询所有
     */
    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }
    /**
     * 增加角色
     * @return
     */
    @Override
    public void saveRole(Role role) {
       roleDao.saveRole(role);
    }
}

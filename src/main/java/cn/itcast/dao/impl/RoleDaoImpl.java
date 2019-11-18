package cn.itcast.dao.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.daomain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private JdbcTemplate template;

    /**
     * 查询所有,角色工作具体内容
     *
     * @return
     */
    @Override
    public List<Role> findAll() {
        String sql = "select * from sys_role";
        List<Role> roleList = template.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    /**
     * 查询角色
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleUser(Long id) {

        String sql= "SELECT * FROM sys_role sr ,sys_user_role ur WHERE sr.id = ur.roleId AND ur.userId = ? ";

        List<Role> roleList = template.query(sql, new BeanPropertyRowMapper<Role>(Role.class),id );
        return roleList;
    }
    /**
     * 增加角色
     * @return
     */
    @Override
    public void saveRole(Role role) {
       String sql = "insert into sys_role values(null,?,?)";
       template.update(sql,role.getRoleName(),role.getRoleDesc());
    }
}

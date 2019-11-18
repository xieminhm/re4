package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate template;

    /**
     * 查询user数据用户管理
     *
     * @return
     */
    @Override
    public List<User> fandAllUserByRole() {
        String sql = "select * from sys_user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    /**
     * 保存用户数据
     * @param user
     */
  /*  @Override
    public long save(final User user) {

        String sql = "insert into sys_user values (null, ?, ?, ?, ?)";
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getEmail());
                ps.setString(3,user.getPassword());
                ps.setString(4,user.getPhoneNum());
                return ps;
            }
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(creator, keyHolder);
        return keyHolder.getKey().longValue();
    }*/
    @Override
    public long save(final User user) {
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成有个PreparedStatement的组建
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(creator,keyHolder);
        //获得生成的主键
        long userId = keyHolder.getKey().longValue();
        return userId; //返回当前保存用户的id 该id是数据库自动生成的
    }


    /**
     * 保存复选框中的角色信息
     * @param userId
     */
    @Override
    public void saveUserRole(long userId, Long[] roleIds) {
     String sql ="insert into sys_user_role values(?,?)";
        for (Long roleId : roleIds) {
            template.update(sql,userId,roleId);
        }
    }
    //删除中间表
    @Override
    public void deleteRoleUser(int userId) {
        String sql= "delete from sys_user_role where userId=?";
        template.update(sql,userId);
    }
    //删除用户表
    @Override
    public void deleteRole(int userId) {
        String sql= "delete from sys_user where id=?";
        template.update(sql,userId);
    }
}

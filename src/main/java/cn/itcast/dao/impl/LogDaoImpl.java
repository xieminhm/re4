package cn.itcast.dao.impl;

import cn.itcast.dao.LogDao;
import cn.itcast.daomain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogDaoImpl implements LogDao {

    @Autowired
    private JdbcTemplate template;
    @Override
    public List<Log> fandAll() {
        String sql = "select * from sys_log";
        List<Log> logList = template.query(sql, new BeanPropertyRowMapper<Log>(Log.class));
        return logList;
    }
    /**
     * 保存log日志
     *
     * @return
     */
    @Override
    public void saveLog(Log log) {
       String sql = "insert into sys_log values (null,?,?,?)";
       template.update(sql,log.getVisitTimeStr(),log.getIp(),log.getUrl());
    }
}

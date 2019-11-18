package cn.itcast.dao;

import cn.itcast.daomain.Log;

import java.util.List;

public interface LogDao {
    List<Log> fandAll();

    void saveLog(Log log);
}

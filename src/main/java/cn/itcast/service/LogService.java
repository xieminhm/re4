package cn.itcast.service;

import cn.itcast.daomain.Log;

import java.util.List;

public interface LogService {
    List<Log> fandAll();

    /**
     * 保存log日志
     *
     * @return
     */
    void saveLog(Log log);
}

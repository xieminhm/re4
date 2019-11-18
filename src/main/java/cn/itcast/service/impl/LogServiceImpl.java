package cn.itcast.service.impl;

import cn.itcast.dao.LogDao;
import cn.itcast.daomain.Log;
import cn.itcast.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    /**
     * 查询log日志
     * @return
     */
    @Override
    public List<Log> fandAll() {
        List<Log> logList = logDao.fandAll();
        return logList;
    }
    /**
     * 保存log日志
     * @return
     */
    @Override
    public void saveLog(Log log) {
        logDao.saveLog(log);
    }


}

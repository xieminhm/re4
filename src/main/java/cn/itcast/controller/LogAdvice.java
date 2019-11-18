package cn.itcast.controller;

import cn.itcast.daomain.Log;
import cn.itcast.service.LogService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;

    @Autowired
    private HttpServletRequest request;

    @Before("execution(* cn.itcast.controller.*.*(..))")
    public void saveLog() {
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("log")){
            Log log = new Log();

            log.setUrl(requestURI);
            String remoteAddr = request.getRemoteAddr();
            log.setIp(remoteAddr);
            log.setVisitTimeStr(new Date());
            logService.saveLog(log);
        }
    }
}

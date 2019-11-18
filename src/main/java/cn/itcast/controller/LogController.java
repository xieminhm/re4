package cn.itcast.controller;

import cn.itcast.daomain.Log;
import cn.itcast.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;



    @RequestMapping("/findAllLog")
    public ModelAndView findAllLog(){
        ModelAndView modelAndView = new ModelAndView();
       List<Log> logList = logService.fandAll();
        modelAndView.addObject("logList",logList);
        modelAndView.setViewName("/pages/syslog-list.jsp");
        return modelAndView;
    }
}

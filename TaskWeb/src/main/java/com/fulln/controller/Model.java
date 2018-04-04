/**
 * 文件名：Model.java
 * <p>
 * 版本信息：
 * 日期：2018年1月12日
 * Copyright fulln Corporation 2018
 * 版权所有
 */
package com.fulln.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.fulln.entity.pro.PlayTaskBasicVO;
import com.fulln.service.Mongo.IarryUserService;
import com.fulln.service.pro.IplayTaskBasicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 *
 * 项目名称：TaskPush    
 * 类名称：Model    
 * 类描述：    
 * 创建人：fulln    
 * 创建时间：2018年1月12日 下午6:14:21          
 * @version
 *
 */
@Controller
@RequestMapping("/home")
public class Model {

    @Reference
    private IplayTaskBasicService playTaskBasicService;

    @Reference
    private IarryUserService arryUserService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String getdetal() {
        return "detail";
    }


    @RequestMapping(value = "/shows", method = RequestMethod.GET)
    public void shows() {
        List<PlayTaskBasicVO> li = playTaskBasicService.findALLTaskList();
        System.out.println(li);
    }

    @RequestMapping(value = {"/login"})
    public String loginPage(@RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            return "logout";
        }
        return "login";
    }

    @RequestMapping("/index")
    public String gethome() {
        return "index";
    }



    @RequestMapping(value = "/Mog",method = RequestMethod.GET)
    public void mog(){
        arryUserService.addToTest();
        System.out.println("插入完成");

        String li=arryUserService.findOne();
        System.out.println(li);
    }


}

package com.fulln.service.Mongo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.fulln.dao.Mongo.arryUserDao;
import com.fulln.entity.Mongo.arryUser;
import com.fulln.service.Mongo.IarryUserService;
import com.fulln.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service
public class arryUserServiceImpl implements IarryUserService {



    @Resource
    private arryUserDao arryUserdao;

    public String addToTest(){
        JSONObject jsonObject = new JSONObject();
        try {
            arryUser ae =  new arryUser();
            ae.setId((long) 3);
            ae.setPassword("456");
            ae.setSex(1);
            ae.setUsername("fulln");
            ae.setCreateDate(DateUtil.getNowTimeStamp());
            ae.setUpdateDate(DateUtil.getNowTimeStamp());
            arryUserdao.insertOne(ae);
            jsonObject.put("result", 1);
        }catch (Exception e){
            jsonObject.put("result",0);
            jsonObject.put("msg", "接口异常，请联系管理员！");
        }
        return jsonObject.toString();
    }

    public String findOne(){
        JSONObject jsonObject = new JSONObject();
        try{
            arryUser ae =  new arryUser();
            ae.setId((long) 3);
            arryUser  li=arryUserdao.findOne(ae);
            jsonObject.put("result",1);
            jsonObject.put("msg",li);
        }catch (Exception e){
            jsonObject.put("result",0);
            jsonObject.put("msg", "接口异常，请联系管理员！");
        }
        return jsonObject.toString();
    }

}

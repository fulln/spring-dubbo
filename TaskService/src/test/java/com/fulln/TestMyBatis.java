package com.fulln;


import com.fulln.entity.pro.PlayTaskBasicVO;
import com.fulln.redis.RedisUtil;
import com.fulln.service.pro.IplayTaskBasicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:META-INF/spring/Application.xml"})
public class TestMyBatis {

    @Resource
    private IplayTaskBasicService playTaskBasicService;

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void getListApplications() throws Exception {

        redisUtil.addValue("face123", "AllTime");
        System.out.println("執行完成");
    }

    @Test
    public void putListApplications() throws Exception {
        List<PlayTaskBasicVO> play = playTaskBasicService.findALLTaskList();

        for (PlayTaskBasicVO playTaskBasicVO : play) {
            System.out.println(playTaskBasicVO.getTaskId());
        }
    }

}
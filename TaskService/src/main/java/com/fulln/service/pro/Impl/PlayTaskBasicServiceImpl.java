/**
 * 文件名：PlayTaskBasicServiceImpl.java
 * <p>
 * 版本信息：
 * 日期：2018-1-11
 * Copyright fulln Corporation 2018
 * 版权所有
 */
package com.fulln.service.pro.Impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.fulln.dao.pro.PlayTaskBasicDao;

import com.fulln.entity.pro.PlayTaskBasicVO;
import com.fulln.service.pro.IplayTaskBasicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 项目名称：   
 * 类名称：PlayTaskBasicServiceImpl    
 * 类描述：实现类
 * 创建人：fulln    
 * 创建时间：2018-1-11 下午02:19:22          
 * @version
 *
 */
@Component
@Service
public class PlayTaskBasicServiceImpl implements IplayTaskBasicService {

    @Autowired
    private PlayTaskBasicDao playtaskbasicdao;

    private Logger log = Logger.getLogger(PlayTaskBasicServiceImpl.class);

    public List<PlayTaskBasicVO> findTaskList() throws Exception {
        return playtaskbasicdao.findPlayTaskList();
    }

    public void updateById(Integer[] ids) {
        try {
            this.playtaskbasicdao.updateById(ids);
        } catch (Exception e) {
            log.error("任务状态更新失败", e);
            e.printStackTrace();
        }
    }

    public List<PlayTaskBasicVO> findALLTaskList() {
        return playtaskbasicdao.findTaskList();
    }


}

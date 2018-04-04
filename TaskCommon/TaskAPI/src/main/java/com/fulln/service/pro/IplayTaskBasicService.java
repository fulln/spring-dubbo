/**
 * 文件名：IplayTaskBasicService.java
 * <p>
 * 版本信息：
 * 日期：2018-1-11
 * Copyright fulln Corporation 2018
 * 版权所有
 */
package com.fulln.service.pro;



import com.fulln.entity.pro.PlayTaskBasicVO;

import java.util.List;


/**
 *
 * 项目名称：pushInfo    
 * 类名称：IplayTaskBasicService    
 * 类描述：   任务查询service类
 * 创建人：fulln    
 * 创建时间：2018-1-11 下午01:54:46          
 * @version
 *
 */
public interface IplayTaskBasicService {

    List<PlayTaskBasicVO> findTaskList() throws Exception;

    List<PlayTaskBasicVO> findALLTaskList();

}


/**
 * 文件名：PlayTaskDao.java
 * <p>
 * 版本信息：
 * 日期：2018-1-11
 * Copyright fulln Corporation 2018
 * 版权所有
 */
package com.fulln.dao.pro;

import com.fulln.entity.pro.PlayTaskBasicVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PlayTaskBasicDao extends Mapper<PlayTaskBasicVO> {

    List<PlayTaskBasicVO> findPlayTaskList();

    void updateById(@Param("ids") Integer[] ids);

    List<PlayTaskBasicVO> findTaskList();
}

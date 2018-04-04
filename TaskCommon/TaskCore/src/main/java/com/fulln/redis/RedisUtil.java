package com.fulln.redis;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class RedisUtil {

    private Logger logger = Logger.getLogger(RedisUtil.class);

    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 根据key，判断是否存在
     *
     * @return true存在
     */
    public boolean exist(String key) {
        boolean flag = false;
        try {
            flag = redisTemplate.hasKey(key);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("判断redis键是否存在失败", e);
        }
        return flag;
    }


    /**
     * @param @param key
     * @param @param code 动态参数，同时支持多个任务码
     * @Description:存储任务码（每个终端有唯一Key）
     */
    public void setLPush(String key, String... code) {
        try {
            redisTemplate.opsForList().rightPush(key, code);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("设置失败.", e);
        }
    }

    /**
     * 获取终端key所有任务码，并移除
     */
    public List<Object> getAndRmCode(String key) {
        List<Object> codes = null;
        try {
            codes = redisTemplate.opsForList().range(key, 0, -1);
            if (codes != null && codes.size() > 0) {
                redisTemplate.opsForList().trim(key, 0, -(codes.size() + 1));
            }
            return codes;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("获取失败.", e);
        }
        return codes;
    }

    /**
     * @param @param  key
     * @param @param  seconds
     * @param @return
     * @return boolean 返回类型
     * @Description:设置失效时间
     */
    public void disableTime(String key, int seconds) {
        try {
            redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("设置失效失败.", e);
        }
    }


    /**
     * 根据key获取value
     */
    public String getValue(String key) {
        String value = "";
        try {
            value = (String) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("根据key获取数据异常", e);
        }
        return value;
    }

    /**
     * @param @param key
     * @param @param value
     * @return void 返回类型
     * @Description:存储key~value
     */

    public boolean addValue(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入数据有异常.", e);
            return false;
        }
    }

    /**
     * @param @param  key
     * @param @return
     * @return boolean 返回类型
     * @Description:删除key
     */
    public boolean delKey(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            logger.error("删除key异常.", e);
            return false;
        }
    }

    /**
     * @param @param key
     * @param @param value
     * @return void 返回类型
     * @Description:set存储key~Map<String, String>
     */

    public void addHValue(String key, Map<String, String> value) {
        try {
            redisTemplate.opsForHash().putAll(key, value);
        } catch (Exception e) {
            logger.debug("插入数据有异常.");
        }
    }

    public Map<Object, Object> getHValue(String key) {
        Map<Object, Object> keyVal = null;
        try {
            keyVal = redisTemplate.opsForHash().entries(key);
            return keyVal;
        } catch (Exception e) {
            logger.debug("插入数据有异常.");
            return keyVal;
        }

    }
}

/**
 *
 */
package com.fulln.util;

import org.apache.log4j.Logger;


/**
 * @author xiaqi
 * 2017-8-1 上午09:29:04
 * @version 1.0
 * 线程工具类
 * waitTime 休眠时间，查询到数据库无任务时，线程进入休眠时间
 * Method dowork() 相关业务处理
 */
public abstract class ThreadUtil extends Thread {

    private long waitTime = 1000l;

    private static final Logger log = Logger.getLogger(ThreadUtil.class);

    private Integer pageSize = 10;

    private boolean stop = true;

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            while (stop) {
                doWork();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            log.error("多线程运行异常！", e);
        }
    }

    public abstract void doWork();

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}

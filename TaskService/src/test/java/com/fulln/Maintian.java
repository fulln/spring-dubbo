/**
 * 文件名：s.java
 * <p>
 * 版本信息：
 * 日期：2018年1月13日
 * Copyright fulln Corporation 2018
 * 版权所有
 */
package com.fulln;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class Maintian {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 30000, new TestWatcher());
        String node = "/node2";
        Stat sta = zk.exists(node, false);
        if (sta == null) {
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        byte[] bk = zk.getData(node, false, sta);
        System.out.println(bk);
        zk.close();
    }


}

class TestWatcher implements Watcher {

    public void process(WatchedEvent arg0) {
        System.out.println("-------start-----");
        System.out.println("path:" + arg0.getPath());
        System.out.println("type:" + arg0.getType());
        System.out.println("state:" + arg0.getState());
        System.out.println("-------end--------");
    }


}
package com.fulln;

import org.apache.log4j.PropertyConfigurator;

public class MongoZookeeperStart {
    static {
        PropertyConfigurator.configure("D:\\worksp\\parents\\TaskConfig\\src\\main\\resources\\log4j.properties");
    }

    public static void main(String[] args) {

        com.alibaba.dubbo.container.Main.main(args);
    }
}

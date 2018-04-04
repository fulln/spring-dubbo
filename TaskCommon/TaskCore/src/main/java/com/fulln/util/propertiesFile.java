package com.fulln.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesFile {

    static{
        loadProps();
    }

    private static Logger logger = LoggerFactory.getLogger(propertiesFile.class);

    private static Properties props;

    synchronized static private void loadProps() {
        props = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream("application.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error("exception");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("读取配置文件流关闭出现异常");
            }
        }
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        if (key != null && !"".equals(key)) {
            return props.getProperty(key);
        } else {
            return null;
        }
    }

}

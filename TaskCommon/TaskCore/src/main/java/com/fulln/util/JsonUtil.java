/**
 *
 */
package com.fulln.util;

import net.sf.json.JSONObject;

/**
 * @author xiaqi
 * 2017-8-1 上午11:41:56
 * @version 1.0
 * JsonUtil.java
 */
public class JsonUtil {

    public static String obj2Json(Object object) {
        return JSONObject.fromObject(object).toString();
    }
}

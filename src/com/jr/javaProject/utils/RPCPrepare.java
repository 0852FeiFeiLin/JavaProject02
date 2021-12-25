package com.jr.javaProject.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 23:33
 * @desc:该类用于封装rpc请求的准备数据的封装类,
 *      利用该类，可以让准备数据这一步骤直接调用这个方法就好，然后返回一个请求体data数据给调用者
 */
public class RPCPrepare {
    public static Map<String,Object> getPrepare(int id,String method,String ...args){//可变参数，可传递好几个值
        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("method", method);
        body.put("params", args);
        body.put("json_rpc", "2.0");
        return body;
    }

}

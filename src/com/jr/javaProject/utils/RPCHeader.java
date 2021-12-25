package com.jr.javaProject.utils;

import com.jr.javaProject.constants.Constants;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 23:34
 * @desc:该类用于封装rpc请求的请求头设置代码类
 */
public class RPCHeader {
    public static Map<String,String> getHeader(){
        //1、准备rpc用户身份信息
        String auth = Constants.BITCION_RPC_USER + ":" + Constants.BITCION_RPC_PWD;
        //进行base64编码成字符串格式
        Base64.Encoder encoder = Base64.getEncoder();
        String authStr = encoder.encodeToString(auth.getBytes());
        //拼接完整的身份认证信息
        authStr = "Basic " + authStr;
        //2、准备请求头信息
        Map<String, String> header = new HashMap<String, String>();
        header.put("ContentType", "application/json");
        header.put("Authorization",  authStr);
        header.put("Encoding", "UTF-8");

        //然后我们把header返回
        return header;
    }
}

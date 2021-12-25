package com.jr.javaProject.service;

import com.alibaba.fastjson.JSONObject;
import com.jr.javaProject.bean.BestBlockHash;
import com.jr.javaProject.constants.Constants;
import com.jr.javaProject.request.HttpUtils;
import com.jr.javaProject.request.RPCRequest;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 11:32
 * @desc:该类用于调用比特币客户端的getbestblockhash命令。返回最新区块的hash值
 *      后面我把具体的实现封装到实现类里面啦RPCServiceImpl
 */
public class GetBestBlockHash {
    public String getBestBlockHash() {
        System.out.println("helloWorld!");
        /*
            准备工作：
                1、准备rpc请求的身份信息
                2、请求头
                3、请求体数据
         */
        //1、准备rpc用户身份信息
        String auth = Constants.BITCION_RPC_USER + ":" + Constants.BITCION_RPC_PWD;
        System.out.println(auth);
        //进行base64编码成字符串格式
        Base64.Encoder encoder = Base64.getEncoder();
        String authStr = encoder.encodeToString(auth.getBytes());
        //拼接完整的身份认证信息
        authStr = "Basic " + authStr;
        System.out.println(authStr);
        //2、准备请求头信息
        Map<String, String> header = new HashMap<String, String>();
        header.put("ContentType", "application/json");
        header.put("Authorization",  authStr);
        header.put("Encoding", "UTF-8");

        //3、准备要发送的rpc数据请求体数据
        Map<String, Object> body = new HashMap<>();
        body.put("id", 10001);
        body.put("method", "getbestblockhash");
        body.put("params", null);
        body.put("json_rpc", "2.0");
        /*
            id: 10001
            method:getbestblockhash
            params:参数
            json_rpc:版本2.0
         */

        //将map转换为byte[],因为方法里面是要的byte[]数据，
        byte[] bodyBytes = JSONObject.toJSONBytes(body);

        //然后调用方法，得到返回值
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, bodyBytes);//path,header,data,
        System.out.println(result);
        //注意：返回的json的数据，那么我们还需要对他进行反序列化
       //反序列化到实体类
        BestBlockHash bestBlockHash = JSONObject.parseObject(result, BestBlockHash.class);
        //输出打印查看
        System.out.println(bestBlockHash.getResult());
        System.out.println(bestBlockHash.getId());
        System.out.println(bestBlockHash.getError());
        //把查询到的结果返回
        return bestBlockHash.getResult();
    }
}

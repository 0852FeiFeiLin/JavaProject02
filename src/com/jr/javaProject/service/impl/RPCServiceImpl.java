package com.jr.javaProject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jr.javaProject.bean.BestBlockHash;
import com.jr.javaProject.bean.BlockCount;
import com.jr.javaProject.bean.RPCResult;
import com.jr.javaProject.constants.Constants;
import com.jr.javaProject.request.RPCRequest;
import com.jr.javaProject.service.RPCService;
import com.jr.javaProject.utils.RPCHeader;
import com.jr.javaProject.utils.RPCPrepare;
import com.jr.javaProject.utils.RPCUtils;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 23:04
 * @desc:
 *      这个是rpc服务的实现类，我们设计让这个类实现外面的rpcService接口，然后重写里面的方法，
 *      从而达到后期只要实例化一个类对象就能调用rpc请求的所有方法
 *  思路：
 *   准备工作：
 *      1、准备rpc请求的身份信息
 *      2、请求头数据
 *             id: 10001
 *             method:getbestblockhash
 *             params:参数
 *             json_rpc:版本2.0
 *      3、请求体数据(序列化)
 *              JSONObject.toJSONByte()
 *   发起请求：
 *      post(url,header,data)
 *   处理响应结果：
 *      JSONObject.parseObject()
 */
public class RPCServiceImpl implements RPCService {
    /*
        获取最新区块哈希值，并返回hash值
     */
    @Override
    public String getBestBlockHash() {
        //1、准备rpc用户身份信息
        //2、准备请求头信息
        Map<String, String> header = RPCHeader.getHeader();//上面这两步只需要，利用下面这个方法，直接返回一个请求头header
        //3、准备要发送的rpc数据请求体数据
        Map<String,Object> data = RPCPrepare.getPrepare(10001, Constants.GETBESTBLOCKHASH);

        //将准备数据的map转换为byte[],因为方法里面是要的byte[]数据，相当于go实现的发送一个管道流
        byte[] rpcData = JSONObject.toJSONBytes(data);

        //然后调用方法，得到返回值响应
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, rpcData);//path,header,data,
        //注意：返回的json的数据，那么我们还需要对他进行反序列化
        //反序列化到实体类
        BestBlockHash bestBlockHash = JSONObject.parseObject(result, BestBlockHash.class);
        //输出打印查看
        System.out.println("最新区块hash值："+bestBlockHash.getResult());
        //把查询到的结果返回
        return bestBlockHash.getResult();
    }
    /*
        获取区块总数量，并返回
     */
    @Override
    public int getBlockCount() {
        //1、获取请求头，准备身份信息
        Map<String, String> header = RPCHeader.getHeader();
        //2、设置请求体,准备数据
        Map<String, Object> data = RPCPrepare.getPrepare(10001, Constants.GETBLOCKCOUNT);
        //3、序列化
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        // 4、调用方法发起请求，返回响应
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        //5、反序列化返回结果
        BlockCount blockCount = JSONObject.parseObject(result, BlockCount.class);
        System.out.println("区块总数量："+blockCount.getResult());
        //6、把反序列化的结果返回
        return blockCount.getResult();
    }
    /*
        获取指定区块信息
     */
    @Override
    public RPCResult getBlock(String hash) {
        //设置身份信息，请求头
        Map<String, String> header = RPCHeader.getHeader();
        //准备数据，id + 命令行+ 参数
        Map<String, Object> data = RPCPrepare.getPrepare(10001, Constants.GETBLOCK,hash);
        //序列化
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        //发起请求，返回响应
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("Block信息："+result);
        //返回反序列化后的结果，存在了rpcResult里面
        RPCResult block = JSONObject.parseObject(result, RPCResult.class);
        return block;
    }

    /*
        获取钱包余额
     */
    @Override
    public RPCResult getBalance() {
        Map<String, String> header = RPCHeader.getHeader();
        Map<String, Object> data = RPCPrepare.getPrepare(10001, Constants.GETBALANCE);
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("余额："+result);
        //返回反序列化后的结果，存在了rpcResult里面
        return JSONObject.parseObject(result, RPCResult.class);
    }
    /*
        获取帮助
     */
    @Override
    public RPCResult getHelp() {
        Map<String, String> header = RPCHeader.getHeader();
        Map<String, Object> data = RPCPrepare.getPrepare(10002, Constants.HTLP);
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("帮助："+result);
        //返回反序列化后的结果，存在了rpcResult里面
        return JSONObject.parseObject(result, RPCResult.class);
    }

    /*
        出块难度
     */
    @Override
    public RPCResult getDifficulty() {
        Map<String, String> header = RPCHeader.getHeader();
        Map<String, Object> data = RPCPrepare.getPrepare(10002, Constants.GETDIFFICULTY);
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("出块难度："+result);
        //返回反序列化后的结果，存在了rpcResult里面
        return JSONObject.parseObject(result, RPCResult.class);
    }

    /*
        获取指定区块的区块头信息
     */
    @Override
    public RPCResult getBlockHeader(String hash) {
        Map<String, String> header = RPCHeader.getHeader();
        Map<String, Object> data = RPCPrepare.getPrepare(10001, Constants.GETBLOCKHEADER,hash);
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("区块头信息："+result);
        //返回反序列化后的结果，存在了rpcResult里面
        return JSONObject.parseObject(result, RPCResult.class);
    }
    /*
        获取区块链当前状态
     */
    @Override
    public RPCResult getBlockChainInfo() {
        Map<String, String> header = RPCHeader.getHeader();
        Map<String, Object> data = RPCPrepare.getPrepare(10001, Constants.GETBLOCKCHAININFO);
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("区块链当前信息："+result);
        return JSONObject.parseObject(result, RPCResult.class);
    }
    /*
        获取当前节点的所有交易输出，utxo
     */
    @Override
    public RPCResult getListunSpent() {
        Map<String, String> header = RPCHeader.getHeader();
        Map<String, Object> data = RPCPrepare.getPrepare(10002, Constants.LISTUNSPENT);
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("当前节点的所有交易输出UTXO："+result);
        return JSONObject.parseObject(result, RPCResult.class);
    }
    /*
        获取最新区块信息，这个方法先获取到bestBlock的hash，然后调用getblock方法查看最新区块的信息
     */
    @Override
    public RPCResult getBestBlockInfo() {
        String bestBlockHash = getBestBlockHash();
        Map<String, String> header = RPCHeader.getHeader();
        Map<String, Object> data = RPCPrepare.getPrepare(10001, Constants.GETBLOCK,bestBlockHash);
        byte[] dataBytes = JSONObject.toJSONBytes(data);
        String result = RPCRequest.post(Constants.BITCION_RPC_URL, header, dataBytes);
        System.out.println("最新区块信息："+result);
        return JSONObject.parseObject(result, RPCResult.class);
    }

}

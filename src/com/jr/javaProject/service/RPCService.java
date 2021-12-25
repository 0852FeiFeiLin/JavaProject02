package com.jr.javaProject.service;

import com.jr.javaProject.bean.RPCResult;

import java.util.List;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 11:31
 * @desc:
 * RPC请求接口：
 *      把该接口定义为rpc服务的标准，该接口里面定义很多的rpc请求方法，
 *      然后后面使用的时候就让指定的类implements实现这个接口，然后重写这里面的方法，
 *      然后后期使用的时候。就实例化一个类就好，然后这样就能该类对象.调用指定调用哪一个方法了，
 *      这样子就不需要每一个rpc请求都实例化一个单独的类
 */

public interface RPCService {
    public String getBestBlockHash();
    public int getBlockCount();
    public RPCResult getBlock(String hash);
    public RPCResult getBalance();
    public RPCResult getHelp();
    public RPCResult getDifficulty();
    public RPCResult getBlockHeader(String hash);
    public RPCResult getBlockChainInfo();
    public RPCResult getListunSpent();
    //自定义的命令方法，获取最新区块info
    public RPCResult getBestBlockInfo();

}

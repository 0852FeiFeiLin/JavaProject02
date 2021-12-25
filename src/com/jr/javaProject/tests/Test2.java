package com.jr.javaProject.tests;

import com.jr.javaProject.bean.RPCResult;
import com.jr.javaProject.service.impl.RPCServiceImpl;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/16 20:18
 * @desc:
 */
public class Test2 {
    public static void main(String[] args) {
        RPCServiceImpl rpcService = new RPCServiceImpl();
        rpcService.getBlock("00000000322cbaf3d8975781d9a19bfbb7b30be50649a31236ccff4089c6e980");
        rpcService.getBlockHeader("00000000322cbaf3d8975781d9a19bfbb7b30be50649a31236ccff4089c6e980");
        rpcService.getBestBlockInfo();
        RPCResult blockChainInfo = rpcService.getBlockChainInfo();
        System.out.println(blockChainInfo.getResult());

    }
}

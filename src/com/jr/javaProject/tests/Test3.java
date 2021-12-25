package com.jr.javaProject.tests;

import com.jr.javaProject.service.BTC_AddressService;
import com.jr.javaProject.service.impl.BTC_AddressServiceImpl;

import java.security.KeyPair;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/22 9:28
 * @desc:
 */
public class Test3 {
    public static void main(String[] args) {

/*
        //getbestblockhash：执行该命令，并返回result数据
        GetBestBlockHash getBestBlockHash = new GetBestBlockHash();
        String bestBlockHash = getBestBlockHash.getBestBlockHash();
        */

        //聚合数据 -- 热门视频榜单api
        /*HotVideoServiceImpl hotVideoService = new HotVideoServiceImpl();
        hotVideoService.getHotVideo();*/

        //聚合数据 -- 天气查询api
        /*WeatherServiceImpl weatherService = new WeatherServiceImpl();
        weatherService.getWeather();*/

      /*  //rpc请求
        RPCServiceImpl rpcService = new RPCServiceImpl();
        rpcService.getBestBlockHash();
        rpcService.getBlockCount();
        rpcService.getBalance();
        rpcService.getDifficulty();
        rpcService.getHelp(); //获取help结果数据
        rpcService.getListunSpent();
        rpcService.getBestBlockInfo();
        rpcService.getBlockChainInfo();
        //有参请求，后期就需要解析前端用户输入的参数，然后传入方法中
        rpcService.getBlock("00000000322cbaf3d8975781d9a19bfbb7b30be50649a31236ccff4089c6e980");
        rpcService.getBlockHeader("00000000322cbaf3d8975781d9a19bfbb7b30be50649a31236ccff4089c6e980");
    */
        //比特币地址生成
        BTC_AddressService btc_address_service = new BTC_AddressServiceImpl();
        KeyPair keyPair = btc_address_service.generateKey();
        String btc_address = btc_address_service.newAddress(keyPair);
        System.out.println("BTC地址"+btc_address);
        boolean isValidate = btc_address_service.isValidate(btc_address);
        System.out.println("BTC地址是否合法"+isValidate);
    }
}

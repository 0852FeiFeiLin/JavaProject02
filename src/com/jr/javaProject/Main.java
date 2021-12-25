package com.jr.javaProject;

import com.jr.javaProject.service.BTC_AddressService;
import com.jr.javaProject.service.HotVideoService;
import com.jr.javaProject.service.RPCService;
import com.jr.javaProject.service.WeatherService;
import com.jr.javaProject.service.impl.BTC_AddressServiceImpl;
import com.jr.javaProject.service.impl.HotVideoServiceImpl;
import com.jr.javaProject.service.impl.RPCServiceImpl;
import com.jr.javaProject.service.impl.WeatherServiceImpl;

import java.security.KeyPair;
import java.util.Scanner;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:该函数是程序的入口，里面可以调用各个方法，并获取到返回的结果集
 * @Date 2021/12/7 16:44
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            menu();
        }

    }

    public static void menu() {
        System.out.println();
        System.out.println("welcome to feiSystem。。。。。");
        System.out.println("本系统主要功能如下：");
        System.out.println("1.热门视频数据 2.天气查询 3.比特币客户端通信 4.比特币地址生成 0.退出");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        String user_input = scanner.next();
        //转换为int类型，如果不是数字，那么就会爆出异常
        int num = Integer.parseInt(user_input);
        switch (num) {
            case 1:
                HotVideoService hotVideoService = new HotVideoServiceImpl();
                hotVideoService.getHotVideo();
                break;
            case 2:
                WeatherService weatherService = new WeatherServiceImpl();
                weatherService.getWeather();
                break;
            case 3:
                //bitCoin二级菜单
                btcCoinMenu();
                break;
            case 4:
                BTC_AddressService btc_address_service = new BTC_AddressServiceImpl();
                KeyPair keyPair = btc_address_service.generateKey();
                String btc_address = btc_address_service.newAddress(keyPair);
                System.out.println("BTC地址" + btc_address);
                boolean isValidate = btc_address_service.isValidate(btc_address);
                System.out.println("BTC地址是否合法" + isValidate);
                break;
            case 0:
                System.exit(0);//终止系统
            default:
                System.out.println("暂时不存在该功能....");
                break;
        }

    }

    /*
        二级菜单：
            就是我们把btc客户端通信的具体里面的小功能列出来，然后放到大菜单里面循环，供用户选择
     */
    public static void btcCoinMenu() {
        System.out.println("这是bitCoin通信，主要功能如下：");
        System.out.println(" 0.调用帮助菜单\n 1.获取最新区块哈希\n 2.获取区块总数\n 3.输入区块哈希，获取区块信息\n 4.查询余额\n " +
                "5.获取出块难度\n 6.获取指定区块区块头信息\n 7.获取区块链的信息\n 8.查看未花费的交易输出UTXO\n 9.获取最新区块区块信息");
        Scanner scanner = new Scanner(System.in);
        String user_input = scanner.next();
        int num = Integer.parseInt(user_input);
        RPCService rpcService = new RPCServiceImpl();
        switch (num) {
            case 0:
                rpcService.getHelp();
                break;
            case 1:
                rpcService.getBestBlockHash();
                break;
            case 2:
                rpcService.getBlockCount();
                break;
            case 3:
                System.out.println("请输入你要查询的区块hash值：");
                Scanner scanner1 = new Scanner(System.in);
                String rpcUser_input = scanner.next();
                rpcService.getBlock(rpcUser_input);
                break;
            case 4:
                rpcService.getBalance();
                break;
            case 5:
                rpcService.getDifficulty();
                break;
            case 6:
                System.out.println("请输入你要查询指定区块头的区块hash值：");
                Scanner scanner2 = new Scanner(System.in);
                String input2 = scanner.next();
                rpcService.getBlockHeader(input2);
                break;
            case 7:
                rpcService.getBlockChainInfo();
                break;
            case 8:
                rpcService.getListunSpent();
                break;
            case 9:
                rpcService.getBestBlockInfo();
                break;
            default:
                System.out.println("功能还在开发中......");
                break;
        }
    }

}
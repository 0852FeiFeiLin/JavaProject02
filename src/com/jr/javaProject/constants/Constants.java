package com.jr.javaProject.constants;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:常量类，用于存放项目中不会变得的变量数据
 * @Date 2021/12/7 10:09
 */
public class Constants {
    //聚合数据旅游达人api
    public static final String TRIP_URL = "http://apis.juhe.cn/fapig/douyin/billboard";
    //聚合数据的请求key
    public static final String KEY = "ab2d1e743ea048ec30a092bb8a18e569";

    //聚合数据天气查询ip和Key
    public static  final String WEATHER_URL = "http://apis.juhe.cn/simpleWeather/query?";
    public static final String W_KEY = "26c586345e411e596178dd3121844420";


    //rpc的配置文件,和bitcoin客户端里面的配置必须一致，
    public static final String BITCION_RPC_URL = "http://127.0.0.1:8332";
    public static final String BITCION_RPC_USER = "feifei";
    public static final String BITCION_RPC_PWD ="085200";

    //rpc命令
    public static final String GETBESTBLOCKHASH  = "getbestblockhash";
    public static final String GETBLOCKCOUNT     = "getblockcount";
    public static final String GETBLOCK          = "getblock";
    public static final String  GETBALANCE        = "getbalance";
    public static final String HTLP              = "help";
    public static final String GETMEMPOOLINFO    = "getmempoolinfo";
    public static final String GETDIFFICULTY     = "getdifficulty";
    public static final String GETBLOCKHEADER    = "getblockheader";
    public static final String GETBLOCKCHAININFO = "getblockchaininfo";
    public static final String LISTUNSPENT       = "listunspent";
}

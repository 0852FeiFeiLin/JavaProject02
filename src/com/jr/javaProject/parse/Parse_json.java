package com.jr.javaProject.parse;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:
 *       这是用于JSON解析的类，我们把json解析封装成一个函数，方便复用
 * @Date 2021/12/9 23:10
 */
public class Parse_json {
    //参数传递JSON数据过来，还有解析到哪个容器里面的容器
    public static  void parseJson(String result,Object data){
        JSONObject.parseObject(result,data.getClass());
        //暂时没了思绪
    }
}

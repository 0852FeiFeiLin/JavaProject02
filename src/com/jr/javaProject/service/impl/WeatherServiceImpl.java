package com.jr.javaProject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jr.javaProject.bean.WeatherCommon;
import com.jr.javaProject.bean.WeatherResult;
import com.jr.javaProject.constants.Constants;
import com.jr.javaProject.request.HttpUtils;

import com.jr.javaProject.request.WeatherRequest;
import com.jr.javaProject.service.WeatherService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:该Server用于聚合数据的天气请求，用户输入城市名，然后我们将查询结果返回，
 * @Date 2021/12/8 12:00
 */
public class WeatherServiceImpl implements WeatherService {
    //http://apis.juhe.cn/simpleWeather/query?city=%E8%8B%8F%E5%B7%9E&key=
    public List<WeatherResult> getWeather() {
        System.out.println("请输入需要查询的城市名：");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();
        //将city进行URL转码，
        try {
            city= URLEncoder.encode(city,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
/*
        System.out.println(city);
*/
        String url = Constants.WEATHER_URL
                + "city=" + city  //注意：签名已经有了?，这里就不需要了。
                + "&key=" + Constants.W_KEY;
        //查看url
        /*System.out.println(url);*/

        //调用天气查询方法
        StringBuffer srb = WeatherRequest.weatherRequest(url);

        //打印查询结果
        System.out.println(srb);


        //进行json解析，(json解析封装成一个函数)
        WeatherCommon weatherCommon = JSONObject.parseObject(String.valueOf(srb), WeatherCommon.class);//强制类型转换成string类型

        /*System.out.println(weatherCommon.getReason());
        System.out.println(weatherCommon.getError_code());
        System.out.println(weatherCommon.getResult());*/

        return weatherCommon.getResult();

    }
}

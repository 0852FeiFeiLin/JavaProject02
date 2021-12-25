package com.jr.javaProject.request;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:该类用于定义天气查询代码， 利用的是JDK自带的HttpURLConnection发起网络请求，
 *      并返回使用StringBuffer封装的结果集数据
 *      然后就是还没解析的然后返回结果集json数据
 * @Date 2021/12/8 15:13
 */
public class WeatherRequest {
    public static StringBuffer weatherRequest(String path) {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        String line ;
        StringBuffer result = null;
        try {
            //创建url
            URL url = new URL(path);
            //打开连接,返回连接对象，(强制类型转换)
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置连接属性
            conn.setDoInput(true);   //连接可输入
            conn.setDoOutput(true);  //连接可输出
            conn.setRequestMethod("POST");//设置请求方式
          //  conn.setRequestProperty("Content-Type", "application/json");
            //发起连接
            conn.connect();
            //获取返回数据
            inputStream = conn.getInputStream();
            //字符转换流，字节流转化为字符流
            inputStreamReader = new InputStreamReader(inputStream);
            //读取字符流内容。缓冲字符输入流
            br = new BufferedReader(inputStreamReader);

            result = new StringBuffer();
            //按行读取
            while ((line = br.readLine()) != null) {
                //返回结果集append添加每一行数据
              result.append(line+"\n");
            }
            //关闭连接
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(br!=null){
                    br.close();
                }
                if (inputStreamReader!=null){
                    inputStreamReader.close();
                }
                if (inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //返回结果集数据，这里我们用的是Stringbuffer可变长字符串封装的。
        return result;
    }


}

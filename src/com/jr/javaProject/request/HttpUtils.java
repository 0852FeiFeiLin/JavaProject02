package com.jr.javaProject.request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:该类用于封装http的网络请求代码，用于发起网络请求，并将网络请求结果集返回，
 * @Date 2021/12/7 10:15
 */
/*
 * 该函数用于实现get请求，并将返回结果返回，
 * @param path 请求的资源路径
 * @return 请求的结果
 * */
public class HttpUtils {
    public static String get(String path) {//请求路径,
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;

        String line = "";//第一次开始读取是空行
        String result = "";//每次读取到的行结果，存读取行的变量

        //url:http:apiurl?key=&type=hot_video
        try {//处理异常
            //1、定义URL  Union Resource Location 统一资源定位器
            URL url = new URL(path);
            //2、打开连接，返回连接对象
            URLConnection conn = url.openConnection();
            //3、设置请求属性
          /*  conn.setDoInput(true); //设置请求时可输入的
            conn.setDoOutput(true); //设置请求时可输出的
            conn.setRequestMethod("GET");//这个需要是HttpURLConnection的时候才能使用
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");//设置数据内容格式
           */
            //4、发起连接  (相当于go语言的Do)
            conn.connect();
            //5、等待数据返回，通过管道流返回，输入流
            inputStream = conn.getInputStream();
            //6、读取输入流中的数据，通过字符流读取到缓冲区中  字符流：行读取，变为字符串readLine
            //字节流转换为字符流
            inputStreamReader = new InputStreamReader(inputStream);//先将输入流放进来转换为字符输入流
            reader = new BufferedReader(inputStreamReader);//将字符流进行读取。
            //按行读取，每次读取一行，readLine
            while ((line = reader.readLine()) != null) {
                //把每一次读取到的行都累加到result里面
                result += line;
            }
            /* conn.getRequestProperties(); //拿到请求返回的所有数据，包括状态码等等。*/
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //7、关闭读取流  先开后闭
                if (reader != null) {
                    reader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();

                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //8、返回结果集
        return result;
    }


}

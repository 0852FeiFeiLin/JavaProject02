package com.jr.javaProject.request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 13:47
 * @desc:
 */
public class RPCRequest {
    /**
     * @param path   请求的路径
     * @param header 请求头数据
     * @param data   请求数据
     * @return 返回的结果
     * @Description 利用java原生代码实现post请求，并返回请求结果
     */
    public static String post(String path, Map<String, String> header, byte[] data) {//url，header请求头数据，请求数据
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        String line;
        String result = "";
        try {
            URL url = new URL(path);
            //强制类型转换成HttpURLConnection，便于后期使用
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方法
            conn.setRequestMethod("POST");
            //设置输入输出
            conn.setDoInput(true);
            conn.setDoOutput(true); //这样才能发送出去
            //请求头设置 利用map，设置成动态的，参数传递过来，

            //如何拿到map数据，如何获取map数据
            //System.out.println("请求头："+header);
            if (!header.isEmpty()) {  //如果不为空
                Set<String> keys = header.keySet();
                for (String key : keys) {
                    String value = header.get(key);
                    //设置请求属性
                    conn.setRequestProperty(key, value);
                }
            }
            //连接
            conn.connect();

            //将请求的数据发送出去
            outputStream = conn.getOutputStream();
            outputStream.write(data);//通过输出流写入数据

            //读取响应的数据
            inputStream = conn.getInputStream();
            //因为字节流一次只能读取一个字节，但是字符流能一次读取一行，readLine读取一行
            /*
                转换流：InputStreamReader     输入读取
                      OutputStreamWriter   输出写入
             */
            //转换流：字节流 --> 字符流
            reader = new BufferedReader(new InputStreamReader(inputStream));//这里就是把字节输入流先转换为字符读取流
            //读取 readLine
            //循环读
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            //返回的还是json的数据，调用者需要对他进行处理
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
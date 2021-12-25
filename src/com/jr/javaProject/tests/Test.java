package com.jr.javaProject.tests;

import com.alibaba.fastjson.JSONObject;
import com.jr.javaProject.bean.HotVideoCommon;
import com.jr.javaProject.constants.Constants;
import com.jr.javaProject.request.HttpUtils;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:该类是程序的入口，main
 * @Date 2021/12/7 9:48
 */
/*
* 里面的代码应该封装到具体的函数里面，这里是测试代码
* */
public class Test {
    public static void main(String[] args) {
        String url = Constants.TRIP_URL+
                "?key="+Constants.KEY
                +"&type=hot_video"
                +"&size=20";
        //发起请求，返回Jason格式的数据
        String result = HttpUtils.get(url);
        System.out.println(result);

        //json解析 (依赖jar包)
        HotVideoCommon videoCommon = JSONObject.parseObject(result, HotVideoCommon.class);
        //将json对象数据，解析成结构体字节码文件

        //打印
        System.out.println(videoCommon.getError_code());
        System.out.println(videoCommon.getReason());
        System.out.println(videoCommon.getResult().size());

    }
}

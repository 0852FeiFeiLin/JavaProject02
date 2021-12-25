package com.jr.javaProject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jr.javaProject.constants.Constants;
import com.jr.javaProject.bean.HotVideo;
import com.jr.javaProject.bean.HotVideoCommon;
import com.jr.javaProject.request.HttpUtils;
import com.jr.javaProject.service.HotVideoService;

import java.util.List;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:该函数用于获取视频热门数据，并返回
 * @Date 2021/12/7 16:41
 */
public class HotVideoServiceImpl implements HotVideoService {
    public List<HotVideo> getHotVideo(){
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
       /* System.out.println(videoCommon.getError_code());*/
        /*System.out.println(videoCommon.getReason());*/
        System.out.println("查询到热门视频个数："+videoCommon.getResult().size());

        //返回结果集
        return videoCommon.getResult();
    }
}

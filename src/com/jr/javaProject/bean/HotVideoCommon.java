package com.jr.javaProject.bean;

import java.util.List;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:热门视频的java数据公共资源实体类
 * @Date 2021/12/7 16:07
 */
public class HotVideoCommon {
    private String reason ;
    private String error_code;
    //数组对象，利用集合存储，然后里面规定类型，里面只能放热门视频，HotVideo，例如里面有20个视频对象，
    private List<HotVideo> result;

    //获取和设置
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}

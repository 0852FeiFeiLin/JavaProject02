package com.jr.javaProject.bean;

import java.util.List;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc: 本类是天气查询的返回大结果集，就是里面包含天气详情，错误码，查询详情。
 * @Date 2021/12/9 15:29
 */
public class WeatherCommon {
    private String reason;
    private List<WeatherResult> result;
    private String error_code;
    /*实际开发中，我们也能使用数组存储数据，数组本身就能规定类型，*/
    //private Realtime[] result1;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<WeatherResult> getResult() {
        return result;
    }

    public void setResult(List<WeatherResult> result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }




}


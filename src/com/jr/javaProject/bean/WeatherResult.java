package com.jr.javaProject.bean;

import java.util.List;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:
 *      该类是天气查询的结果集类，里面负责很多的存储具体的天气详情
 * @Date 2021/12/9 16:24
 */

public class WeatherResult {
    private String city;
    private List<Realtime> realtime;
    private List<Future> futures;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Realtime> getRealtime() {
        return realtime;
    }

    public void setRealtime(List<Realtime> realtime) {
        this.realtime = realtime;
    }

    public List<Future> getFutures() {
        return futures;
    }

    public void setFutures(List<Future> futures) {
        this.futures = futures;
    }
}

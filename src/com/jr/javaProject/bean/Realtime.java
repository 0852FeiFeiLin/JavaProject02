package com.jr.javaProject.bean;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc: 该类就是存储该城市天气的具体详情的实体类，存储的就是温度，风向等等，，，
 * @Date 2021/12/9 16:14
 */
public class Realtime {
    private int temperature;
    private int humidity;
    private String info ;
    private String wid;
    private String direct;
    private String power;
    private int aqi;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }
}

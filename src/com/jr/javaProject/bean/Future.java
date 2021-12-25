package com.jr.javaProject.bean;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @QQ 2778368047
 * @PhoneNum 18170618733
 * @desc:
 *      该实体类是存放天气查询的未来天气预报的类，
 * @Date 2021/12/9 16:14
 */
public class Future {
    private String date;
    private String temperature;
    private String weather;
    private Wid[] wid;
    private String direct;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Wid[] getWid() {
        return wid;
    }

    public void setWid(Wid[] wid) {
        this.wid = wid;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
}

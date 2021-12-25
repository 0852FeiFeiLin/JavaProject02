package com.jr.javaProject.bean;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 19:45
 * @desc:这个是rpc服务的公有类，里面封装了一些rpc请求过程中共同的数据，例如id，error
 */
public class RPCCommon {
    private int id;
    private String error;

    public RPCCommon() {
    }

    public RPCCommon(int id, String error) {
        this.id = id;
        this.error = error;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

package com.jr.javaProject.bean;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/16 15:35
 * @desc: 本类用于纪录rpc请求返回的结果集数据，就是所有的返回值都是利用result Object类型接收
 */
public class RPCResult {
    private int id;
    private String error;
    private Object result;

    public RPCResult(int id, String error, Object result) {
        this.id = id;
        this.error = error;
        this.result = result;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

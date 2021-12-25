package com.jr.javaProject.bean;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 19:43
 * @desc:这个是getbestblockhash对应的实体类
 */
public class BestBlockHash extends RPCCommon {
    //继承了rpc共有类，默认拥有id和error属性,下面的是他自己拓展的属性
    private String result ;

    //构造方法
    public BestBlockHash(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

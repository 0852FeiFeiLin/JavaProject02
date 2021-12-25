package com.jr.javaProject.bean;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/15 22:41
 * @desc:这个实体类对应getblockcount的数量
 */
public class BlockCount extends RPCCommon {
    private int result;

    //构造方法
    public BlockCount(int result) {
        super();
        this.result = result;
    }
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}

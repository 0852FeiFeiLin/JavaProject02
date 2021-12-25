package com.jr.javaProject.service;

import com.jr.javaProject.utils.Base58;
import com.jr.javaProject.utils.Hash;

import java.security.*;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/22 8:58
 * @desc:
 */

 /*
    大致流程：
        1、随机生成私钥 ECC
        1、得到对应的公钥
        3、对公钥进行来两次hash计算，（1.sha256  2.ripemd160）
        4、在3的后面添加版本号
        5、然后进行双重hash，取hash2的前四个字节，作为校验码，添加在最后面，
        6、然后base58编码得到地址
        7、检验地址是否合法，反解码 ---> 取check 作为标准答案，
            截取ver_pub ,然后进行两次hash计算，得出check1，作为我们计算的答案，
            然后check1 和 check2 进行比较，判断是否相等
     */
public interface BTC_AddressService {
    public String newAddress(KeyPair keyPair);
    public boolean isValidate(String BTC_Address);
    public KeyPair generateKey();
}

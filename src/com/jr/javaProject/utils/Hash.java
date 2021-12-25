package com.jr.javaProject.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/22 9:56
 * @desc: 该类用于hash算法的封装
 */
public class Hash {
    /*
        该函相用于实现对数据进行hash计算，，并返回hash值
     */
    public static byte[] SHA256(byte[] data){ //接收的数据是byte[]
        try{
            //Md  Message Digest
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            //加密数据
            messageDigest.update(data);
            //返回加密后的数据
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static  byte[] RipeMD160(byte[] data){
        //告诉计算机我们已经支持这种算法了
        Security.addProvider(new BouncyCastleProvider());

        try {
            MessageDigest digest = MessageDigest.getInstance("RipeMD160");
            digest.update(data);
            //返回进行Ripemd计算后的hash值
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}

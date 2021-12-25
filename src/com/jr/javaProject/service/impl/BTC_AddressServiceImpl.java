package com.jr.javaProject.service.impl;

import com.jr.javaProject.service.BTC_AddressService;
import com.jr.javaProject.utils.Base58;
import com.jr.javaProject.utils.Hash;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;

/**
 * @Author 芒果果
 * @Hobby Keep
 * @PhoneNum 18170618733
 * @Date 2021/12/22 16:32
 * @desc:我利用了接口封装，我们通过实现接口，并重写里面的newAddress方法，接口里面方法有：
 *         方法一：用于生成btcAddress的，然后将生成的地址返回
 *         方法二：isValidate，验证地址是否合法
 */
public class BTC_AddressServiceImpl implements BTC_AddressService {
    /**
     * @param keyPair 密钥信息
     * @return 生成的原始格式地址
     * @Author 芒果果
     * @Description 该方法用于根据提供的keyPair密钥信息推导歘原始格式地址
     * @Date 9:12 2021/12/22
     */
    public String newAddress(KeyPair keyPair) {
        //1、获取到公钥类对象
        ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
       /* //得到公钥数据
        //公钥格式：04 + x坐标 + y坐标
        //公钥对象包含ecc公钥对象，他们是包含关系，所以我们还要获取到具体的ECPublickey
        //2/先获取到店point
        ECPoint ecPoint = ecPublicKey.getW();


        //获取到x坐标和y坐标
        byte[] xbytes = ecPoint.getAffineX().toByteArray();
        byte[] ybytes = ecPoint.getAffineY().toByteArray();
        System.out.println(xbytes.length);
        System.out.println(ybytes.length);
        //我们发现最后的坐标会出现33个字节，然后我们现在需要进行判断和处理，如果是33字节，截取[1:33]
*/
        //拼接处理，得到原始格式公钥,
        byte[] pubKey = toUnCompressPubKey(ecPublicKey);

        //对原始公钥进行hash计算
        byte[] sha256 = Hash.SHA256(pubKey);
        //再进行ripemd160
        byte[] pubHash = Hash.RipeMD160(pubKey);

        //版本号
        byte[] version = new byte[1];
        version[0] = 0x00;


        //创建新数组，
        byte[] ver_pubHash = new byte[pubHash.length + version.length];
        //拷贝版本号 + pubHash ==> ver_pubHash
        System.arraycopy(version, 0, ver_pubHash, 0, version.length);
        System.arraycopy(pubHash, 0, ver_pubHash, 1, pubHash.length);

        //双hash取前四个字节作为校验码
        byte[] hash1 = Hash.SHA256(ver_pubHash);
        byte[] hash2 = Hash.SHA256(hash1);

        //校验码数组
        byte[] check = new byte[4];
        //取前四个字节，拷贝到新数组
        System.arraycopy(hash2, 0, check, 0, check.length);
        //申请ver_pub_check 数组空间
        byte[] ver_pub_check = new byte[ver_pubHash.length + check.length];
        //
        System.arraycopy(ver_pubHash, 0, ver_pub_check, 0, ver_pubHash.length);
        //校验位拼接到新数组里面
        System.arraycopy(check, 0, ver_pub_check, ver_pubHash.length, check.length);
        //拷贝check，从0开始，放到ver_pub_check，从上一步添加了ver_pubHas的位置开始放，拷贝check的长度

        //Base58编码得到地址
        String addr = Base58.encode(ver_pub_check);
        //输出地址
        /*System.out.println(addr);*/

        return addr;
    }
    /**
     * @Author 芒果果
     * @Description //该函数用于生成密钥对，
     * @Date 16:36 2021/12/22
     * @param
     * @return 返回KeyPair密钥对
     */
    public KeyPair generateKey() {
        try {
            //生成ECC密钥对，
            KeyPairGenerator generator = KeyPairGenerator.getInstance("EC"); //or名词
            //secp256k1、secp256r1
            //指定参数
            ECGenParameterSpec secp = new ECGenParameterSpec("secp256k1"); //这里可能写错 了
            //初始化
            generator.initialize(secp);
            //生成密钥
            KeyPair keyPair = generator.generateKeyPair(); //和generateKey一样的
            return keyPair;
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author 芒果果
     * @Description //该函数用于拼接公钥，并处理出现33字节的情况，。然后我们得到未压缩原始格式的公钥
     * @Date 16:47 2021/12/22
     * @param ecPublicKey 就是ECC生成的公钥对象，然后我们得到point，然后得到x和y坐标
     * @return 原始格式公钥
     */
    public byte[] toUnCompressPubKey(ECPublicKey ecPublicKey) {
        ECPoint point = ecPublicKey.getW();
        //得到x坐标和y坐标
        byte[] xBytes = point.getAffineX().toByteArray();
        byte[] yBytes = point.getAffineY().toByteArray();

        //申请65字节大小的字节数组存储公钥
        byte[] pubKey = new byte[1 + 2 * 32];
        pubKey[0] = 04;
        //判断x 坐标长度
        if (xBytes.length == 32) {
            //可以利用for循环把数据加到数组里面，也可以利用system
            System.arraycopy(xBytes, 0, pubKey, 1, xBytes.length);
            //你要拷贝的数组，拷贝开始下标，拷贝到哪里去，从哪里开始放，拷贝多长
        } else if (xBytes.length > 32) { //如果是33字节长度
            System.arraycopy(xBytes, 1, pubKey, 1, 32);
        }

        //判断y坐标
        if (yBytes.length == 32) {//将y坐标拷贝到pubKey里面
            System.arraycopy(yBytes, 0, pubKey, 33, 32);
            //数组拷贝：     拷贝谁，从哪里开始拷贝，拷贝到哪里去，从哪里开始放，拷贝多长
        } else if (yBytes.length > 32) {//大于32字节，那么就从1开始，截取数组加到pubKey[]
            System.arraycopy(yBytes, 1, pubKey, 33, 32);
        }
        //将65字节的公钥字节数组返回
        return pubKey;
    }

    /**
     * @Author 芒果果
     * @Description //校验地址是否符合规范，并返回校验结果,
     * @Date 16:50 2021/12/22
     * @param addr 比特币地址
     * @return boolean  true==符合规范，false=不符合规范
     */
    public boolean isValidate(String addr) {
        if ("".equals(addr) || addr == null) { //判断是否为空
            return false;
        }
        //1、Base58反解码
        byte[] ver_pub_check = Base58.decode(addr);
        //判断反解码出来的地址有没有四位
        if (ver_pub_check.length < 4) {
            return false;
        }
        //截取，
        //申请存储校验位的数组空间
        byte[] check = new byte[4];
        System.arraycopy(ver_pub_check, ver_pub_check.length - 4, check, 0, check.length);
        byte[] ver_pub = new byte[ver_pub_check.length - check.length];//减去检验位的长度
        System.arraycopy(ver_pub_check, 0, ver_pub, 0, ver_pub.length);

        //对得到的版本号 + 原始公钥哈希进行双重hash，
        byte[] hash1 = Hash.SHA256(ver_pub);
        byte[] hash2 = Hash.SHA256(hash1);

        //把hash的前四个字节取出来作为我们计算出来的答案
        byte[] check_sum = new byte[4];
        System.arraycopy(hash2, 0, check_sum, 0, check.length);//hash2，从0开始拷贝，拷贝到check2，放到0位开始，拷贝check1的场长度，也就是所有的check1数据
        //取出来校验码，并拷贝到check2里面
        //比较两个数组是否相等,并返回
        return Arrays.equals(check, check_sum);
    }

}

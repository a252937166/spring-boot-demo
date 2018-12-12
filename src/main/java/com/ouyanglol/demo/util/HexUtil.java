package com.ouyanglol.demo.util;

import io.netty.handler.codec.DecoderException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.codec.Hex;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Ouyang
 */
@Slf4j
public class HexUtil {
    private  static final String AES = "AES";
    private static final String KEY = "spring demo 4 us";
    /**
     * AES加密
     * @param content 需要加密的内容
     * @return 加密内容
     */
    private static byte[] encrypt(String content) {
        try {
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), AES);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // 加密内容进行编码
            byte[] byteContent = content.getBytes(UTF_8);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 正式执行加密操作
            return cipher.doFinal(byteContent);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            log.error("加密失败-->{}",e.getMessage());
        }
        return null;
    }

    /**
     * AES解密
     * @param contents 需要解密的内容
     * @return 解密内容
     * @throws DecoderException
     */
    private static byte[] decrypt(String contents) {
        try {
            //密文使用Hex解码
            byte[]content = Hex.decode(contents);
            //秘钥 Hex解码为什么秘钥要进行解码，因为秘钥是某个秘钥明文进行了Hex编码后的值，所以在使用的时候要进行解码
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), AES);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(AES);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 正式执行解密操作
            return cipher.doFinal(content);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException e) {
            log.error("解密失败-->{}",e.getMessage());
        }
        return null;
    }

    /**
     * Aes加密
     * @param context 明文
     * @return 加密内容
     */
    public static String  encryption(String context) {
        //加密后的明文也就变成了密文
        byte[] encryptResult = encrypt(context);
        //密码文Hex编码
        return Hex.encodeToString(encryptResult);
    }

    /**
     * Aes解密
     * @param context 密文
     * @return 解密内容
     */
    public static String decryption(String context) {
        //这里的密文解密前先进行了Hex解码
        byte[] decryptResult = decrypt(context);
        return new String(decryptResult, UTF_8);
    }

}

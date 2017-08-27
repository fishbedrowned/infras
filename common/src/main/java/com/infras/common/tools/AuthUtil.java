package com.infras.common.tools;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.time.OffsetTime;
import java.util.Optional;

/**
 * Created by zhaoheng on 2017/8/13.
 */
public class AuthUtil {

    private static final String AUTH_METHOD = "PBKDF2WithHmacSHA1";
    private static final String SECRET = "Eish2Thing5phe5uaQuualaixai5Infras";
    private static final int INTERATIONS = 1024;
    private static final int LEN = 256;

    public static Optional<String> generateToken(String raw){
        // TODO 应该写到数据库中、保密
        final String AUTH_METHOD = "HmacSHA1";
        final String SECRET = "Eish2Thing5phe5uaQuualaixai5Infras";
        return _generateShSecret(raw, AUTH_METHOD, SECRET);
    }

    public static Optional<String> generatePassword(String password){

        // TODO 应该写到数据库中、保密、64位密码
        final String AUTH_METHOD = "PBKDF2WithHmacSHA1";
        final String SECRET = "Eish2Thing5phe5uaQuualaixai5Infras";
        final int INTERATIONS = 1024;
        final int LEN = 256;

        return _generatePbeSecret(password, AUTH_METHOD, INTERATIONS, LEN, SECRET);
    }

    private static Optional<String> _generatePbeSecret(String password, String authMethod, int interations, int lenS, String secret){
        try{
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), secret.getBytes(), interations, lenS);
            SecretKeyFactory kFactory= SecretKeyFactory.getInstance(authMethod);
            SecretKey secretKey = kFactory.generateSecret(pbeKeySpec);
            byte[] buff = secretKey.getEncoded();
            return Optional.of(Hex.encodeHexString(buff));
        }catch (Exception e) {
            System.out.print(e.getMessage());
            return Optional.empty();
        }
    }


    private static Optional<String> _generateShSecret(String password, String authMethod, String secret){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(), authMethod);
            Mac mac = Mac.getInstance(authMethod);
            mac.init(keySpec);

            byte[] buff = mac.doFinal(password.getBytes());
            return Optional.of(Hex.encodeHexString(buff));
        }catch (Exception e) {
            System.out.print(e.getMessage());
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
//        System.out.println(OffsetTime.now().getNano());
//        Optional<String> p =  generateToken("123456");
//        System.out.println(OffsetTime.now().getNano());
//        p.ifPresent(t -> System.out.print(t+"   "+t.length()));
    }
}

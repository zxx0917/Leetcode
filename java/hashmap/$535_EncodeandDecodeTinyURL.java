package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class $535_EncodeandDecodeTinyURL {
}

/**
 * 生成6位随机码，拼接PREFIX得到加密后的地址，将加密前地址和加密后地址分别作为KEY/VALUE加入两个Map
 */
class Codec {
    public static final String PREFIX = "https://tinyurl.com/";
    //加密前->加密后
    Map<String, String> enToDe = new HashMap<>();
    //加密后->加密前
    Map<String, String> deToEn = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = PREFIX + getCode();
        enToDe.put(longUrl, shortUrl);
        deToEn.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return deToEn.get(shortUrl);
    }

    private String getCode() {
        StringBuilder sb = new StringBuilder();
        String code = "0123456789qwertyuiopasdfghjklzxvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(code.charAt(random.nextInt(code.length())));
        }
        return sb.toString();
    }
}
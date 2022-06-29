package CodecUrl;

import java.util.Base64;

/**
 * @author: ffzs
 * @Date: 2022/6/29 下午1:31
 */
public class Codec {

    Base64.Encoder encoder = Base64.getEncoder();
    Base64.Decoder decoder = Base64.getDecoder();
    public String encode(String longUrl) {
        return encoder.encodeToString(longUrl.getBytes());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return new String(decoder.decode(shortUrl));
    }

}

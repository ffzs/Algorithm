package entityParser;

/**
 * @author: ffzs
 * @Date: 2023/11/23 上午9:41
 */
public class Solution {

    public String entityParser(String text) {
        text = text.replace("&quot;", "\"");
        text = text.replace("&apos;", "'");
        text = text.replace("&gt;", ">");
        text = text.replace("&lt;", "<");
        text = text.replace("&frasl;", "/");
        text = text.replace("&amp;", "&");
        return text;
    }

}

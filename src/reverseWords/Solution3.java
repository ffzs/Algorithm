package reverseWords;

import java.util.stream.Stream;

/**
 * @author: ffzs
 * @Date: 2020/8/30 上午7:57
 */
public class Solution3 {
    public String reverseWords(String s) {
        return Stream.of(s.split(" ")).map(it->new StringBuilder(it).reverse().toString()).reduce((v1, v2)-> v1+" "+ v2).get();
    }
}

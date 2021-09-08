package fullJustify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/9/9 上午6:48
 * 最后一行左对齐
 * 中间对齐左边放置空格多
 * 只有一个单词也是左对齐
 */
public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, len = 0;
        List<Integer> index = null;
        while (i < words.length) {
            len = 0;
            index = new ArrayList<>();
            while (i < words.length && len + words[i].length() <= maxWidth) {
                len ++;
                len += words[i].length();
                index.add(i);
                i ++;
            }
            res.add(justify(index, words, maxWidth-len + 1, false, maxWidth));
        }
        res.remove(res.size()-1);
        res.add(justify(index, words, maxWidth-len + 1, true, maxWidth));
        return res;
    }

    private String justify(List<Integer> index, String[] words, int n, boolean last, int maxWidth) {

        if (index.size() == 1) {
            String w = words[index.get(0)];
            return new StringBuilder().append(w).append(" ".repeat(maxWidth-w.length())).toString();
        }
        if (last) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : index) {
                sb.append(words[integer]);
                if (sb.length() < maxWidth) sb.append(" ");
            }
            sb.append(" ".repeat(maxWidth-sb.length()));
            return sb.toString();
        }
        n += index.size() - 1;
        int[] tmp = new int[index.size()-1];
        for (int i = 0; i < n; i++) {
            tmp[i%tmp.length] ++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index.size(); i++) {
            sb.append(words[index.get(i)]);
            if (i < tmp.length) sb.append(" ".repeat(tmp[i]));
        }
        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        System.out.println(s.fullJustify(words, 16));
    }
}

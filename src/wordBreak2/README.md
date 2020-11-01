## [140. 单词拆分 II](https://leetcode-cn.com/problems/word-break-ii/)

## 题目

给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

```java
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
```

```java
示例 2：

输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
```

```java
示例 3：

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
```


链接：https://leetcode-cn.com/problems/word-break-ii



## 解题记录

+ 通过set记录是否s中有的字符值wordDict中没有的，如果是，直接返回空集合
+ 剩下的逻辑和 [Leetcode:NO.139 单词拆分 动态规划](https://blog.csdn.net/tonydz0523/article/details/106954920)的基本相同
+ 在匹配的过程中进行字符串统计

```java
/**
 * @author: ffzs
 * @Date: 2020/11/1 上午9:15
 */
public class Solution {

    Map<Character, List<String>> map = new HashMap<>();
    char[] seq;
    public List<String> wordBreak(String s, List<String> wordDict) {
        seq = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (String s1 : wordDict) {
            Character f = s1.charAt(0);
            if (!map.containsKey(f)) map.put(f, new ArrayList<>());
            map.get(f).add(s1);
            for (char c : s1.toCharArray()) {
                set.add(c);
            }
        }

        for (char c : seq) {
            if (!set.contains(c)) return new ArrayList<>();
        }

        boolean[] step = new boolean[seq.length +1];
        step[0] = true;
        Map<Integer, List<String>> tmp = new HashMap<>();
        tmp.put(seq.length, new ArrayList<>());
        for (int i = 0; i < seq.length ; i++) {
            if (step[i] && map.containsKey(seq[i])){
                for (String s1 : map.get(seq[i])) {
                    if (isMatch(seq, s1, i)) {
                        int index = i+s1.length();
                        if (!tmp.containsKey(index)) tmp.put(index, new ArrayList<>());
                        if (i==0) tmp.get(index).add(s1);
                        else {
                            for (String s2 : tmp.get(i)) {
                                tmp.get(index).add(s2 + " " + s1);
                            }
                        }
                        step[i+s1.length()] = true;
                    }
                }
            }
        }
        System.out.println(tmp);
        return tmp.get(seq.length);
    }

    private boolean isMatch (char[] seq, String s, int start) {
        if (start + s.length() > seq.length) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != seq[start+i]) return false;
        }
        return true;
    }
}
```

![image-20201101122048000](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201101122048000.png)

## 进阶

+ 通过回溯算法计算
+ 同时也要先考察是否有可以达到目的的方案，不然的话频繁的读写list是很费时间的

```java
/**
 * @author: ffzs
 * @Date: 2020/11/1 下午12:21
 */
public class Solution2 {

    Map<Character, List<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    char[] seq;
    boolean[] step;
    public List<String> wordBreak(String s, List<String> wordDict) {
        seq = s.toCharArray();
        for (String s1 : wordDict) {
            Character f = s1.charAt(0);
            if (!map.containsKey(f)) map.put(f, new ArrayList<>());
            map.get(f).add(s1);
        }

        step = new boolean[seq.length + 1];
        step[0] = true;
        for (int i = 0; i < seq.length ; i++) {
            if (step[i] && map.containsKey(seq[i])){
                for (String s1 : map.get(seq[i])) {
                    if (isMatch(seq, s1, i)) {
                        step[i+s1.length()] = true;
                    }
                }
            }
        }
        if (step[seq.length]) dfs(0, new ArrayList<>());
        return res;
    }


    private void dfs (int i, List<String> list) {
        if (i == seq.length) {
            res.add(String.join(" ", list));
            return;
        }
        if (!map.containsKey(seq[i]) || !step[i]) return;
        for (String s1 : map.get(seq[i])) {
            int index = i+s1.length();
            if (index <= seq.length && step[index] && isMatch(seq, s1, i)) {
                list.add(s1);
                dfs(index, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isMatch (char[] seq, String s, int start) {
        if (start + s.length() > seq.length) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != seq[start+i]) return false;
        }
        return true;
    }
}
```

![image-20201101123241835](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201101123241835.png)
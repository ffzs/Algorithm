## [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/)

## 题目

给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

```java
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
```


链接：https://leetcode-cn.com/problems/word-ladder

## 解题记录

+ 通过广度优先处理
+ 详细逻辑见 [Leetcode:NO.126 单词接龙 II 广度优先搜索](https://blog.csdn.net/tonydz0523/article/details/106602864)

```java
/**
 * @author: ffzs
 * @Date: 2020/11/5 上午9:42
 */
public class Solution2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        int min = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        char[][] iChar = new char[beginWord.length()][26];
        Map<Integer, Set<Character>> map = new HashMap<>();

        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(i)) map.put(i, new HashSet<>());
                map.get(i).add(s.charAt(i));
            }
        }

        for (int i = 0; i < beginWord.length(); i++) {
            int j = 0;
            for (Character c : map.get(i)) {
                iChar[i][j++] = c;
            }
        }

        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean flag = false;
        int level = 1;

        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                assert word != null;
                char[] chars = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char tmp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch ++) {
                        chars[j] = ch;
                        if (tmp == ch) continue;
                        String str = new String(chars);
                        if (wordSet.contains(str) && !visited.contains(str)) {
                            if (str.equals(endWord)) {
                                flag = true;
                                min = Math.min(min, level+1);
                            }
                            else subVisited.add(str);
                            queue.add(str);
                        }
                    }
                    chars[j] = tmp;
                }
            }
            visited.addAll(subVisited);
            level++;
        }

        return min == Integer.MAX_VALUE?0:min;
    }
}
```

![image-20201105110920591](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201105110920591.png)

## 进阶

+ 双向深度优先搜索
+ 通过双向的dfs可以通过较少的一边查向较多的一边，不会出现过多的循环情况

```java
/**
 * @author: ffzs
 * @Date: 2020/11/5 上午7:53
 */

public class Solution {
    char[][] iChar;
    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        iChar = new char[beginWord.length()][26];
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(i)) map.put(i, new HashSet<>());
                map.get(i).add(s.charAt(i));
            }
        }

        for (int i = 0; i < beginWord.length(); i++) {
            int j = 0;
            for (Character c : map.get(i)) {
                iChar[i][j++] = c;
            }
        }

        Set<String> start = new HashSet<>();
        start.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        return dfs(start, end, 2);
    }


    private int dfs (Set<String> start, Set<String> end, int level) {
        if (start.size() == 0) return 0;
        if (start.size()>end.size()) return dfs(end, start, level);

        wordSet.removeAll(start);
        Set<String> nextLevel = new HashSet<>();
        for (String s : start) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char cur = chars[i];
                for (char c : iChar[i]) {
                    if (c == 0) break;
                    if (c == cur) continue;
                    chars[i] = c;
                    String next = new String(chars);
                    if (wordSet.contains(next)) {
                        if (end.contains(next)) return level;
                        else nextLevel.add(next);
                    }
                }
                chars[i] = cur;
            }
        }
        return dfs(nextLevel, end, level+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordList = new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"));
        String beginWord="hit", endWord = "cog";
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
```

![image-20201105112543882](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201105112543882.png)

+ 由于比较费时的几个测试用例，基本是a~z都占齐了，而且，start，end只有一组，我上面写的优先统计出每个位置的字符出现情况其实反而拖慢了测试速度
+ 但是这并不表示实际生产中优先统计每一位字符出现情况没有用
+ 下面是去掉统计一部的代码， 速度会快一些

```java
/**
 * @author: ffzs
 * @Date: 2020/11/5 上午11:28
 */
public class Solution3 {

    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> start = new HashSet<>();
        start.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        return dfs(start, end, 2);
    }


    private int dfs (Set<String> start, Set<String> end, int level) {
        if (start.size() == 0) return 0;
        if (start.size()>end.size()) return dfs(end, start, level);

        wordSet.removeAll(start);
        Set<String> nextLevel = new HashSet<>();
        for (String s : start) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char cur = chars[i];
                for (char c='a'; c<='z'; c++) {
                    if (c == cur) continue;
                    chars[i] = c;
                    String next = new String(chars);
                    if (wordSet.contains(next)) {
                        if (end.contains(next)) return level;
                        else nextLevel.add(next);
                    }
                }
                chars[i] = cur;
            }
        }
        return dfs(nextLevel, end, level+1);
    }
}
```

![image-20201105113113882](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201105113113882.png)
## [1178. 猜字谜](https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/)

## 题目

外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。

字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：

+ 单词 word 中包含谜面 puzzle 的第一个字母。
+ 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
  例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。

返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。

```java
示例：

输入：
words = ["aaaa","asas","able","ability","actt","actor","access"], 
puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
输出：[1,1,3,2,4,0]
解释：
1 个单词可以作为 "aboveyz" 的谜底 : "aaaa" 
1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
```

```java
提示：

1 <= words.length <= 10^5
4 <= words[i].length <= 50
1 <= puzzles.length <= 10^4
puzzles[i].length == 7
words[i][j], puzzles[i][j] 都是小写英文字母。
每个 puzzles[i] 所包含的字符都不重复。
```


链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle

## 解题记录

+ 通过map存储信息puzzles的信息，然后遍历words通过每一个查找是否存在匹配的情况



```java
/**
 * @author: ffzs
 * @Date: 2021/2/26 上午8:11
 */
public class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Map<String, Set<Integer>>> map = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            indexMap.put(puzzle, i);
            char[] chars = puzzle.toCharArray();
            int cur = chars[0] - 'a';
            if (!map.containsKey(cur)) map.put(cur, new HashMap<>());
            Map<String, Set<Integer>> subMap = map.get(cur);
            if (!subMap.containsKey(puzzle)) subMap.put(puzzle, new HashSet<>());
            Set<Integer> set = subMap.get(puzzle);
            for (char c : chars) {
                set.add(c - 'a');
            }
        }
        Integer[] res = new Integer[puzzles.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < words.length; i++) {
            boolean[] tmp = new boolean[26];
            char[] cs = words[i].toCharArray();
            for (int c : cs) {
                tmp[c - 'a'] = true;
            }
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] && map.containsKey(j)) {
                    Map<String, Set<Integer>> subMap = map.get(j);
                    for (Map.Entry<String, Set<Integer>> e : subMap.entrySet()) {
                        if (check(tmp, e.getValue())) res[indexMap.get(e.getKey())] ++;
                    }
                }
            }

        }

        return Arrays.stream(res).collect(Collectors.toList());
    }

    private boolean check (boolean[] tmp, Set<Integer> set) {
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] && !set.contains(i)) return false;
        }
        return true;
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(solution.findNumOfValidWords(words, puzzles));
    }
}
```

![image-20210226100722945](README.assets/image-20210226100722945.png)

困难难度不出所料超时了。

## 进阶

+ 通过状态压缩，因为是26个字母将words的set形式通过一个长度为26的二进制表示，有该位置为1,否则为0

```java
/**
 * @author: ffzs
 * @Date: 2021/2/26 上午10:10
 */
public class Solution2 {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            char[] cs = word.toCharArray();
            int mask = 0;
            for (char c : cs) {
                mask |= (1 << (c - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (String puzzle : puzzles) {
            int counter = 0;
            char[] cs = puzzle.toCharArray();
            int mask = 0;
            for (int i = 1; i < cs.length; i++) {
                mask |= (1 << (cs[i] - 'a'));
            }

            int cur = mask;
            int head = (1 << (cs[0] - 'a'));
            do {
                int s = cur | head;
                if (map.containsKey(s)) counter += map.get(s);
                cur = (cur - 1) & mask;
            } while (cur != mask);

            res.add(counter);
        }
        return res;
    }

}
```

![image-20210226111648376](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210226111648376.png)

+ 通过字典树对words的内容进行统计，通过排序的方法使得字符在树中的成一定的顺序
+ 然后通过回溯的方法判断puzzle的子集是否存在，存在获取频率



```java
/**
 * @author: ffzs
 * @Date: 2021/2/26 上午10:46
 */

class TrieNode {
    int frq = 0;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}

public class Solution3 {
    TrieNode root = new TrieNode();
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        for (String word : words) {
            char[] cs = word.toCharArray();
            boolean[] tmp = new boolean[26];
            for (char c : cs) tmp[c - 'a'] = true;

            add(root, tmp);
        }

        List<Integer> res = new ArrayList<>(puzzles.length);

        for (String puzzle : puzzles) {
            char[] cs = puzzle.toCharArray();
            Arrays.sort(cs);
            res.add(find(cs, puzzle.charAt(0), root, 0));
        }

        return res;
    }

    private void add (TrieNode root, boolean[] tmp) {
        TrieNode cur = root;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i]) {
                if (cur.children[i] == null) cur.children[i] = new TrieNode();
                cur = cur.children[i];
            }
        }
        cur.frq++;
    }

    private int find(char[] cs, char head, TrieNode cur, int pos) {
        if (cur == null) return 0;

        if (pos >= 7) return cur.frq;

        int ret = find(cs, head, cur.children[cs[pos] - 'a'], pos+1);

        if (cs[pos] != head) ret += find(cs, head, cur, pos+1);

        return ret;
    }
}
```

![image-20210226111515210](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210226111515210.png)
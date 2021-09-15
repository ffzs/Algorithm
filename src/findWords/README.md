## 212. 单词搜索 II

## 题目

给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

 

```java
示例 1：


输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]
示例 2：


输入：board = [["a","b"],["c","d"]], words = ["abcb"]
输出：[]
```




```java
提示：

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] 是一个小写英文字母
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] 由小写英文字母组成
words 中的所有字符串互不相同
```

链接：https://leetcode-cn.com/problems/word-search-ii


## 解题记录

+ 通过字典树记录所有word的前后关系
+ 然后通过回溯算法获得，如果拼成单词的话，那么就把字典树中的该词去掉避免重复添加

```java
/**
 * @author: ffzs
 * @Date: 2021/9/16 上午6:52
 */

class Trie {
    String word;
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        this.word = "";
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}

public class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, trie, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, Trie now, int i1, int j1) {
        char c = board[i1][j1];
        if (!now.children.containsKey(c)) return;

        Trie next = now.children.get(c);

        if (!next.word.equals("")) {
            res.add(next.word);
            next.word = "";
        }

        if (!next.children.isEmpty()) {
            board[i1][j1] = '#';
            for (int[] dir : directions) {
                int i2 = i1 + dir[0], j2 = j1 + dir[1];
                if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) dfs(board, next, i2, j2);
            }
            board[i1][j1] = c;
        }
        if (next.children.isEmpty()) now.children.remove(c);
    }

}
```

![image-20210916072047855](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210916072047855.png)
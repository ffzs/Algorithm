## 208. 实现 Trie (前缀树)

## 题目

```java
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。


示例：

输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
```



```java
提示：

1 <= word.length, prefix.length <= 2000
word 和 prefix 仅由小写英文字母组成
insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
```


链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree

## 解题记录

+ 因为是小写的英文字母组成那么通过长度为26的列表存储即可
+ 出现下一个字符的话添加，末尾添加end标识
+ search的话要检查最后的是否为end
+ startsWith不用检查end

```java
/**
 * @author: ffzs
 * @Date: 2021/4/14 上午8:03
 */
public class Trie {
    static class TrieNode {
        public TrieNode[] node;
        private boolean isEnd;

        public TrieNode() {
            node = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] cs = word.toCharArray();
        TrieNode cur = root;
        for (char c : cs) {
            int i = c - 'a';
            if (cur.node[i] == null) cur.node[i] = new TrieNode();
            cur = cur.node[i];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = find(word);
        return cur != null && cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String word) {
        char[] cs = word.toCharArray();
        TrieNode cur = root;
        for (char c : cs) {
            int i = c - 'a';
            if (cur.node[i] == null) return cur.node[i];
            cur = cur.node[i];
        }
        return cur;
    }
}
```

![image-20210414085531810](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210414085531810.png)
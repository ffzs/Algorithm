## 211. 添加与搜索单词 - 数据结构设计

## 题目

请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。

```java
示例：

输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
```



```java
提示：

1 <= word.length <= 500
addWord 中的 word 由小写英文字母组成
search 中的 word 由 '.' 或小写英文字母组成
最多调用 50000 次 addWord 和 search
```


链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure

## 解题记录

+ 通过前缀树进行处理
+ 这里有个地方需要注意就是'.'的处理，因为'.'可以替换任何字符，那么久通过递归的方式查找该位置所有情况是否有匹配

```java
/**
 * @author: ffzs
 * @Date: 2021/10/19 下午5:34
 */

class Node {
    public Node[] children;
    private boolean isEnd;
    public Node() {
        children = new Node[26];
        this.isEnd = false;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}


public class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = this.root;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.setEnd(true);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Node node){
        if (idx == word.length()) return node.isEnd();

        char c = word.charAt(idx);
        if (c == '.'){
            for (Node child : node.children) {
                if (child != null && dfs(word, idx+1, child)) return true;
            }
        }
        else {
            Node cur = node.children[word.charAt(idx) - 'a'];
            if (cur != null && dfs(word, idx + 1, cur)) return true;
        }
        return false;
    }

}
```

![image-20211019182727269](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211019182727269.png)
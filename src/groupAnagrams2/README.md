## 面试题 10.02. 变位词组

## 题目

编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。

注意：本题相对原题稍作修改

```java
示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

```java
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
```


链接：https://leetcode-cn.com/problems/group-anagrams-lcci

## 解题记录

+ 通过对字符串的字符进行排序，以致所有的变位词可以为用一个key
+ 然后通过map进行分类存储

```java
/**
 * @author: ffzs
 * @Date: 2021/7/18 上午8:22
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            if (!map.containsKey(str)) map.put(str, new ArrayList<>());
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
```

![image-20210718084307362](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210718084307362.png)
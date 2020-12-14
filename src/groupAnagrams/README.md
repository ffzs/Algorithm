## [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

## 题目

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

```java
示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
```


链接：https://leetcode-cn.com/problems/group-anagrams

## 解题记录

+ 将字符中的字符重新排序作为key，然后用map将同样key的放到一个list，然后将这些list转存到list中返回即可

```java
/**
 * @author: ffzs
 * @Date: 2020/12/14 上午10:25
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

![image-20201214105125195](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201214105125195.png)
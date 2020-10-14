## [1002. 查找常用字符](https://leetcode-cn.com/problems/find-common-characters/)

## 题目

给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

 

```java
示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
```

```java
示例 2：

输入：["cool","lock","cook"]
输出：["c","o"]
```

```java
提示：

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母
```


链接：https://leetcode-cn.com/problems/find-common-characters

## 解题记录

+ 对每个单词的字母进行统计，然后根据该字母的最小个数写到list中

```java
/**
 * @author: ffzs
 * @Date: 2020/10/14 上午7:34
 */
public class Solution {

    public List<String> commonChars(String[] A) {
        int[][] tmp = new int['z'-'a'+1][A.length];
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            for (char c : chars) {
                tmp[c-'a'][i]++;
            }
        }

        List<String> res = new ArrayList<>();
        int min;
        for (int i = 0; i < tmp.length; i++) {
            min = A.length;
            for (int l : tmp[i]) {
                min = Math.min(l, min);
            }
            if (min > 0) {
                char letter = (char) ('a' + i);
                for (int j = 0; j < min; j++) {
                    res.add(""+letter);
                }
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] A = {"bella","label","roller"};
        System.out.println(solution.commonChars(A));
    }
}
```

![image-20201014081646815](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201014081646815.png)

+ 因为之前字符串中没有出现的字母不可能实现，那么就没有必要统计
+ 而且可以一边统计一边获取整体最小值

```java
/**
 * @author: ffzs
 * @Date: 2020/10/14 上午7:59
 */
public class Solution2 {

    public List<String> commonChars(String[] A) {
        int[] counter = new int['z'-'a' +1];
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            if (i == 0) {
                for (char c : chars) counter[c-'a']++;
            }else {
                int[] tmp = new int['z'-'a' +1];
                for (char c : chars) tmp[c-'a']++;
                for (int j = 0; j < counter.length; j++) {
                    if (counter[j] !=0) counter[j] = Math.min(counter[j], tmp[j]);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0){
                for (int i1 = 0; i1 < counter[i]; i1++) {
                    res.add(String.valueOf((char)(i+'a')));
                }
            }
        }
        return res;
    }
}
```

![image-20201014081623065](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201014081623065.png)
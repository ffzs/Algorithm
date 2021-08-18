## 345. 反转字符串中的元音字母

## 题目

编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 

```java
示例 1：

输入："hello"
输出："holle"
示例 2：

输入："leetcode"
输出："leotcede"
```



```java
提示：

元音字母不包含字母 "y" 。
```


链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string

## 解题记录

+ 双指针从头尾查找元音
+ 然后进行替换即可

```java
/**
 * @author: ffzs
 * @Date: 2021/8/19 上午6:37
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int l = 0, r = cs.length-1;
        while (l < r) {
            while (l < r && !isVowel(cs[l], vowel)) l++;
            while (l < r && !isVowel(cs[r], vowel)) r--;
            char tmp = cs[l];
            cs[l] = cs[r];
            cs[r] = tmp;
            l++;
            r--;
        }
        return new String(cs);
    }

    private boolean isVowel(char i, char[] vowel) {

        for (char c : vowel) {
            if (i == c) return true;
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("leetcode"));
    }
}
```

![image-20210819070208822](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210819070208822.png)
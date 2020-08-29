## [214. 最短回文串](https://leetcode-cn.com/problems/shortest-palindrome/)

## 题目

给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

```java
示例 1:

输入: "aacecaaa"
输出: "aaacecaaa"
```

```java
示例 2:

输入: "abcd"
输出: "dcbabcd"
```


链接：https://leetcode-cn.com/problems/shortest-palindrome

## 解题记录

+ 回文判断
+ 通过双指针进行比对
+ right指针分别从后向前循环
+ 然后获取子字符串判断是否为回文
+ 之后补全后边即可

```java
/**
 * @author: ffzs
 * @Date: 2020/8/29 上午8:15
 */
public class Solution2 {
    public String shortestPalindrome(String s) {
        char[] seq = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = seq.length-1; i >= 0; --i) {
            if (isPalindrome(seq, i)) {
                for (int j = seq.length-1; j > i; j--) res.append(seq[j]);
                res.append(seq);
                return res.toString();
            }
        }
        return res.toString();
    }

    private boolean isPalindrome (char[] seq, int right) {
        int left = 0;
        while (left<=right) {
            if (seq[left++] != seq[right--]) return false;
        }
        return true;
    }
}
```

![image-20200829094146133](README.assets/image-20200829094146133.png)

## 进阶

+ 使用中心扩散

```java
public class Solution {
    public static String shortestPalindrome(String s) {
        char[] seq = s.toCharArray();
        if(seq.length == 0) return s;
        int left, right;
        StringBuilder res = new StringBuilder();
        for (int i = (seq.length-1)/2; i >= 0; i--) {
            for (int k = 0; k < 2 ; k++) {
                if ((seq.length & 1) == 1){
                    left = i-k;
                    right = i;
                }else{
                    left = i;
                    right = i+1-k;
                }
                while (left>=0 && seq[left] == seq[right]) {
                    if(left == 0){
                        for(int j = seq.length-1; j>right; --j) res.append(seq[j]);
                        return res.append(seq).toString();
                    }
                    left--; right++;
                }
            }
        }
        return res.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = "aacecaaa";

        System.out.println(Solution.shortestPalindrome(s));
    }
}
```

![image-20200829094204494](README.assets/image-20200829094204494.png)

## 在进阶

+ 我们将字符串反过来s2
+ 将s和s2进行比对并记录比对相同的个数，即便出现了位置错了也没关系，因为是回文所以之后一定还会有
+ 回文字符的个数直到以后，由于剩下的那部分一定是非回文部分，将剩下的调转加到前面即可
+ 由于只有一个字符回文的情况会导致第二个字符找到相同等情况，只要将字符串截出来递归判断即可

```java
/**
 * @author: ffzs
 * @Date: 2020/8/29 上午9:58
 */
public class Solution3 {
    public String shortestPalindrome(String s) {
        char[] seq = s.toCharArray();

        int i=0;
        for (int j = seq.length-1; j >= 0; --j) {
            if (seq[i] == seq[j]) i++;
        }
        if (i == seq.length) return s;
        StringBuilder res = new StringBuilder(s.substring(i));
        res = res.reverse();
        return res.append(shortestPalindrome(s.substring(0,i))).append(s.substring(i)).toString();
    }
}
```

![image-20200829101339574](README.assets/image-20200829101339574.png)
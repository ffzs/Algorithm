## 443. 压缩字符串

## 题目

给你一个字符数组 chars ，请使用下述算法压缩：

从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：

如果这一组长度为 1 ，则将字符追加到 s 中。
否则，需要向 s 追加字符，后跟这一组的长度。
压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。

请在 修改完输入数组后 ，返回该数组的新长度。

你必须设计并实现一个只使用常量额外空间的算法来解决此问题。

```java
示例 1：

输入：chars = ["a","a","b","b","c","c","c"]
输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
解释：
"aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
示例 2：

输入：chars = ["a"]
输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
解释：
没有任何字符串被替代。
示例 3：

输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
解释：
由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
注意每个数字在数组中都有它自己的位置。
```



```java
提示：

1 <= chars.length <= 2000
chars[i] 可以是小写英文字母、大写英文字母、数字或符号
```


链接：https://leetcode-cn.com/problems/string-compression

## 解题记录

+ 通过局部双指针统计重复个数，然后写入字符数组
+ 空缺位置通过0填补
+ 最后将空缺部分补齐即可

```java
/**
 * @author: ffzs
 * @Date: 2021/8/21 上午7:02
 */
public class Solution {

    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        while (i < n) {
            int j = i, c = 1;
            while (i + 1 < n && chars[j] == chars[i + 1]) {
                chars[i+1] = 0;
                i++;
                c++;
            }
            if (c > 1) digitLen(c, chars, j + 1);
            System.out.println(chars);
            i++;
        }
        i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] != 0) {
                chars[i++] = chars[j];
            }
        }

        return i;
    }

    private void digitLen(int num, char[] chars, int idx) {
        for (char c : String.valueOf(num).toCharArray()) {
            chars[idx++] = c;
        }
    }
}
```

![image-20210821073555124](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210821073555124.png)
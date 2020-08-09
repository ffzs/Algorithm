## [93. 复原IP地址](https://leetcode-cn.com/problems/restore-ip-addresses/)

## 题目

给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

 

```java
示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
```


链接：https://leetcode-cn.com/problems/restore-ip-addresses

## 解题记录

+ 直接暴力枚举
+ 通过三个指针将字符串分为四个部分
+ 判断四部分是否满足要求即可

```java
/**
 * @author: ffzs
 * @Date: 2020/8/9 上午7:33
 */


public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int i = 1, j, k;
        while (i<=3){
            j = i + 1;
            while (j-i>0 && j-i<=3 && j < s.length() -1) {
                k = j+1;
                while (k-j >0 && k-j <=3 && k < s.length()) {
                    String ret = isNum(s, i, j, k);
                    if (!ret.equals("")) result.add(ret);
                    k++;
                }
                j++;
            }
            i++;
        }
        return result;
    }

    private String isNum (String s, int i, int j, int k) {
        if (s.length()-1 - k > 3) return "";
        String s1 = s.substring(0,i);
        String s2 = s.substring(i,j);
        String s3 = s.substring(j,k);
        String s4 = s.substring(k);
        System.out.println(s1 + "." + s2 + "." + s3 + "." + s4);
        if (ifBetween(s1) && ifBetween(s2) && ifBetween(s3) && ifBetween(s4)) {
            return s1 + "." + s2 + "." + s3 + "." + s4;
        }
        return "";
    }

    private boolean ifBetween (String it) {
        if (it.equals("") || it.length() > 3) return false;
        if (it.length() > 1 && it.charAt(0) == '0') return false;
        if (it.length() == 3) return Integer.parseInt(it) <= 255;
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "0000";
        System.out.println(solution.restoreIpAddresses(s));
    }
}
```

![image-20200809082806569](README.assets/image-20200809082806569.png)

## 进阶

+ 使用回溯算法
+ 每添加一个数值为一个阶段，每个阶段有三种情况：数值为1位，2位，3位
+ 通过递归的方式进行回溯操作

```java
/**
 * @author: ffzs
 * @Date: 2020/8/9 上午8:29
 */
public class Solution2 {
    private List<String> res;
    private char[] chars, tmp;
    private int n;
    public List<String> restoreIpAddresses(String s) {
        chars = s.toCharArray();
        res = new ArrayList<String>();
        n = chars.length;
        tmp = new char[n+3]; // 三个'.' 的位置
        backtrace(0,0);
        return res;
    }

    private void backtrace(int i, int level) {
        if (n - i < 4 - level || n - i > (4-level) * 3) return;

        if (level == 4) {
            res.add(new String(tmp));
            return;
        }

        if (level > 0) tmp[i+level-1] = '.'; // 每一层添加 .
        // 1位数值
        tmp[i + level] = chars[i];
        backtrace(i+1, level +1);

        // 2位数值
        if (chars[i] == '0' || i >= n-1) return; // 2位数不能以 0开头例如：01应为1
        tmp[i+level+1] = chars[i+1];
        backtrace(i+2, level+1);

        // 3为数值
        if(i+2 < n && (chars[i]-'0')*100 + (chars[i+1]-'0')*10 + (chars[i+2]-'0') <=255) {
            tmp[i+level+2] = chars[i+2];
            backtrace(i+3, level+1);
        }
    }
}
```

![image-20200809091345417](README.assets/image-20200809091345417.png)
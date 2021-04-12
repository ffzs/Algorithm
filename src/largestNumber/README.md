## 179. 最大数

给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 

```java
示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"

示例 3：
输入：nums = [1]
输出："1"

示例 4：
输入：nums = [10]
输出："10"
```

```java
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 109
```


链接：https://leetcode-cn.com/problems/largest-number

## 解题记录

+ 通过比对两个数值拼接之后的大小对nums进行排序
+ 然后依照顺序写入字符串即可

```java
/**
 * @author: ffzs
 * @Date: 2021/4/12 上午8:32
 */
public class Solution {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] nms = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nms[i] = nums[i];
        }
        Arrays.sort(nms, this::helper);

        if (nms[0] == 0) return "0";

        StringBuilder sb = new StringBuilder();
        for (Integer nm : nms) {
            sb.append(nm);
        }

        return sb.toString();
    }

    private int helper(int num1, int num2) {
        int[] tmp1 = new int[20];
        int[] tmp2 = new int[20];
        int n = toArray(tmp1, num2, toArray(tmp1, num1, 0));
        toArray(tmp2, num1, toArray(tmp2, num2, 0));

        for (int i = n - 1; i >= 0; i--) {
            if(tmp1[i] != tmp2[i]) return tmp1[i] - tmp2[i];
        }

        return 1;
    }

    private int toArray (int[] value, int num, int i) {
        if (num == 0) {
            value[i] = 0;
            return i+1;
        }

        while (num >= 1) {
            value[i++] = num%10;
            num /= 10;
        }
        return i;
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {34323,3432};
        System.out.println(s.largestNumber(nums));
    }
}
```

![image-20210412095302540](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210412095302540.png)
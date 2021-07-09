## 981. 基于时间的键值存储

## 题目

创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：

1. set(string key, string value, int timestamp)

存储键 key、值 value，以及给定的时间戳 timestamp。
2. get(string key, int timestamp)

返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
如果没有值，则返回空字符串（""）。

```java
示例 1：

输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
输出：[null,null,"bar","bar",null,"bar2","bar2"]
解释：  
TimeMap kv;   
kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1   
kv.get("foo", 1);  // 输出 "bar"   
kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）   
kv.set("foo", "bar2", 4);   
kv.get("foo", 4); // 输出 "bar2"   
kv.get("foo", 5); // 输出 "bar2"   

示例 2：

输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
输出：[null,null,null,"","high","high","low","low"]
```



```java
提示：

所有的键/值字符串都是小写的。
所有的键/值字符串长度都在 [1, 100] 范围内。
所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
1 <= timestamp <= 10^7
TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
```


链接：https://leetcode-cn.com/problems/time-based-key-value-store

## 解题记录

+ 简单通过map进行存储
+ 然后更新最大时间戳即可
+ 获取数的时候比较时间戳大小



```java
/**
 * @author: ffzs
 * @Date: 2021/7/10 上午6:57
 */
public class TimeMap {
    Map<String, Map<String, Integer> > map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>(){{put(value, timestamp);}});
        }
        else {
            Map<String, Integer> subMap = map.get(key);
            if (!subMap.containsKey(value)) subMap.put(value, timestamp);
            else {
                int the_time = subMap.get(value);
                if (timestamp > the_time) subMap.put(value, timestamp);
            }
        }
    }

    public String get(String key, int timestamp) {
        int max = Integer.MIN_VALUE;
        String v = "";
        Map<String, Integer> subMap = map.getOrDefault(key, new HashMap<>());
        for (Map.Entry<String, Integer> entry : subMap.entrySet()) {
            int the_time = entry.getValue();
            if (timestamp>=the_time && the_time>max) {
                v = entry.getKey();
                max = the_time;
            }
        }
        return v;
    }

}
```

![image-20210710073245730](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210710073245730.png)
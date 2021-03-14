## [706. 设计哈希映射](https://leetcode-cn.com/problems/design-hashmap/)

## 题目

不使用任何内建的哈希表库设计一个哈希映射（HashMap）。

实现 MyHashMap 类：

MyHashMap() 用空映射初始化对象
void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。

```java
示例：

输入：
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
输出：
[null, null, null, 1, -1, null, 1, null, -1]

解释：
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
```

```java
提示：
0 <= key, value <= 106
最多调用 104 次 put、get 和 remove 方法

进阶：你能否不使用内置的 HashMap 库解决此问题？
```

链接：https://leetcode-cn.com/problems/design-hashmap



## 解题记录

+ 通过自己编写hash逻辑处理
+ 和set不同的是，map的容器里需要装一对数值

```java
/**
 * @author: ffzs
 * @Date: 2021/3/14 下午5:36
 */
public class MyHashMap {
    private final int BASE = 731;
    private LinkedList[] box;

    /** Initialize your data structure here. */
    public MyHashMap() {
        box = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            box[i] = new LinkedList<int[]>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = getHash(key);
        LinkedList<int[]> list = box[h];
        for (int[] i : list) {
            if (i[0] == key) {
                i[1] = value;
                return;
            }
        }
        list.add(new int[] {key, value});
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = getHash(key);
        LinkedList<int[]> list = box[h];

        for (int[] i : list) {
            if (i[0] == key) return i[1];
        }

        return -1;
    }


    public void remove(int key) {
        int h = getHash(key);
        LinkedList<int[]> list = box[h];
        int j = 0;
        for (int[] i : list) {
            if (i[0] == key) {
                list.remove(j);
                return;
            }
            j++;
        }
    }

    private int getHash(int key) {
        return key % BASE;
    }
}
```

![image-20210314183435057](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210314183435057.png)
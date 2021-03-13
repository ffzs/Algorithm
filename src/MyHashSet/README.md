## 705. 设计哈希集合](https://leetcode-cn.com/problems/design-hashset/)

## 题目

不使用任何内建的哈希表库设计一个哈希集合（HashSet）。

实现 MyHashSet 类：

void add(key) 向哈希集合中插入值 key 。
bool contains(key) 返回哈希集合中是否存在这个值 key 。
void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。



```java
示例：

输入：
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
输出：
[null, null, null, true, false, null, true, null, false]

解释：
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      //  set = [1]
myHashSet.add(2);      //  set = [1, 2]
myHashSet.contains(1);  // 返回 True
myHashSet.contains(3);  // 返回 False ，（未找到）
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2);  // 返回 True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // 返回 False ，（已移除）
```

```java
提示：
0 <= key <= 106
最多调用 104 次 add、remove 和 contains 。
```

进阶：你可以不使用内建的哈希集合库解决此问题吗？

链接：https://leetcode-cn.com/problems/design-hashset



## 解题记录

+ 直接借助Hashmap处理

```java
/**
 * @author: ffzs
 * @Date: 2021/3/13 下午1:05
 */
public class MyHashSet {
    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, 1);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
```

![image-20210313135147644](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210313135147644.png)

## 进阶

+ 自己为数组做hash处理，通过一个base将数值分成不同组，每一组通过一个链表存储数据
+ 当add的时候查询，没有重复添加
+ 当remove的时候，查询有的话移出
+ 当contain的时候，查询有的话则返回true

```java
/**
 * @author: ffzs
 * @Date: 2021/3/13 下午1:57
 */
public class MyHashSet2 {
    private final int BASE = 731;
    private LinkedList[] box;

    public MyHashSet2() {
        box = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            box[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = getHash(key);
        LinkedList<Integer> list = box[h];
        for (Integer i : list) {
            if (i == key) return;
        }
        list.add(key);
    }

    public void remove(int key) {
        int h = getHash(key);
        LinkedList<Integer> list = box[h];
        for (Integer i : list) {
            if (i == key) {
                list.removeFirstOccurrence(i);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = getHash(key);
        LinkedList<Integer> list = box[h];
        for (Integer i : list) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    private int getHash(int key) {
        return key % BASE;
    }

}
```

![image-20210313142117671](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210313142117671.png)
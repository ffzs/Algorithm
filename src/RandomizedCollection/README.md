## [381. O(1) 时间插入、删除和获取随机元素 - 允许重复](https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/)

## 题目

设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。

注意: 允许出现重复元素。

insert(val)：向集合中插入元素 val。
remove(val)：当 val 存在时，从集合中移除一个 val。
getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。

```java
示例:

// 初始化一个空的集合。
RandomizedCollection collection = new RandomizedCollection();

// 向集合中插入 1 。返回 true 表示集合不包含 1 。
collection.insert(1);

// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
collection.insert(1);

// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
collection.insert(2);

// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
collection.getRandom();

// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
collection.remove(1);

// getRandom 应有相同概率返回 1 和 2 。
collection.getRandom();
```


链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed

## 解题记录

+ 通过一个map记录插入值的index
+ 通过一个list收集插入值情况
+ 在删除的时候通过删除map中对应的一个index，再对应删除掉list中相应index
+ 为了不保持插入删除的时候都从list的最后实现

```java
/**
 * @author: ffzs
 * @Date: 2020/10/31 上午8:52
 */
public class RandomizedCollection {
    private final Map<Integer, Set<Integer>> collect;
    private final List<Integer> vals;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.collect = new HashMap<>();
        this.vals = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        vals.add(val);
        if (!collect.containsKey(val)) collect.put(val, new HashSet<>());
        collect.get(val).add(vals.size()-1);
        return collect.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> set = collect.get(val);
        if (set == null || set.size() == 0) return false;
        else {
            int lastIndex = vals.size()-1;
            int lastValue = vals.get(lastIndex);
            if (lastValue == val) {
                set.remove(lastIndex);
            }
            else{
                int index = set.iterator().next();
                vals.set(index, lastValue);
                set.remove(index);
                Set<Integer> lastSet = collect.get(lastValue);
                lastSet.remove(lastIndex);
                lastSet.add(index);
            }
            vals.remove(lastIndex);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return vals.get(ThreadLocalRandom.current().nextInt(vals.size()));
    }
}
```

![image-20201031112806705](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201031112806705.png)
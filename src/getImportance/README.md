## 690. 员工的重要性

## 题目

给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。

比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。

现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。

```java
示例：

输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
输出：11
解释：
员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
```

```java
提示：

一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
员工数量不超过 2000 。
```


链接：https://leetcode-cn.com/problems/employee-importance

## 解题记录

+ 通过将list中的员工的id和员工信息存储到一个map中，这样我们在搜索子员工的时候可以直接通过id找到
+ 然后通过深度优先搜索对员工的重要度进行累加即可

```java
/**
 * @author: ffzs
 * @Date: 2021/5/1 上午8:39
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Solution {
    Map<Integer, List<Integer>> sub = new HashMap<>();
    Map<Integer, Integer> imp = new HashMap<>();
    int res = 0;
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            sub.put(employee.id, employee.subordinates);
            imp.put(employee.id, employee.importance);
        }
        dfs(id);
        return res;
    }

    private void dfs (int id) {
        if (!sub.containsKey(id)) return;
        res += imp.get(id);
        for (int i : sub.get(id)) {
            dfs(i);
        }
    }

}
```

![image-20210501092205946](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210501092205946.png)

+ 可以通过在原来的对象上进行修改，将下属的所有重要值加到一起，类似于将树的子树的值加和统一到父节点，这样可以节省内存的使用

```java
/**
 * @author: ffzs
 * @Date: 2021/5/1 上午9:22
 */
public class Solution2 {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);
    }

    private int dfs(int id) {

        Employee cur = map.get(id);
        for (int i : cur.subordinates) {
            cur.importance += dfs(i);
        }
        return cur.importance;
    }
}
```

![image-20210501092948667](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210501092948667.png)
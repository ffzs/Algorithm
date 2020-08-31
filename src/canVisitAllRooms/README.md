## [841. 钥匙和房间](https://leetcode-cn.com/problems/keys-and-rooms/)

## 题目

有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 `rooms[i][j]` 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 `rooms[i][j]` = v 可以打开编号为 v 的房间。

最初，除 0 号房间外的其余所有房间都被锁住。

你可以自由地在房间之间来回走动。

如果能进入每个房间返回 true，否则返回 false。

```java
示例 1：

输入: [[1],[2],[3],[]]
输出: true
解释:  
我们从 0 号房间开始，拿到钥匙 1。
之后我们去 1 号房间，拿到钥匙 2。
然后我们去 2 号房间，拿到钥匙 3。
最后我们去了 3 号房间。
由于我们能够进入每个房间，我们返回 true。
```

```java
示例 2：

输入：[[1,3],[3,0,1],[2],[0]]
输出：false
解释：我们不能进入 2 号房间。
提示：

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
所有房间中的钥匙数量总计不超过 3000。
```


链接：https://leetcode-cn.com/problems/keys-and-rooms

## 解题记录

[Leetcode: NO.332 重新安排行程 回溯算法+深度优先](https://blog.csdn.net/tonydz0523/article/details/108255724)跟这个题是一个类型

+ 通过回溯算法
+ 通过构建数组来进行判断是否进入过某个房间
+ 

```java
/**
 * @author: ffzs
 * @Date: 2020/8/31 上午7:54
 */
public class Solution {

    boolean flag = true;
    List<List<Integer>> map;
    boolean[] in;
    int count;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.map = rooms;
        this.in = new boolean[rooms.size()];
        this.count = rooms.size();
        canVisitAllRooms(0, rooms.size()-1);
        return !flag;
    }

    private void canVisitAllRooms (int room, int times){
        if (flag) {
            if (!in[room]) {
                in[room] = true;
                if (--count == 0){
                    flag = false;
                    return;
                }
            }
            if (map.get(room)!=null&&!map.get(room).isEmpty()) {
                List<Integer> tmp = map.get(room);
                int size = map.get(room).size();
                for (int i = 0; i < size; i++) {
                    Integer nextRoom = tmp.remove(0);
                    canVisitAllRooms(nextRoom, times-1);
                    tmp.add(nextRoom);
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(List.of(1)));
        rooms.add(new ArrayList<>(List.of(2)));
        rooms.add(new ArrayList<>(List.of(3)));
        rooms.add(new ArrayList<>());
        System.out.println(solution.canVisitAllRooms(rooms));
    }
}
```

![image-20200831083610576](README.assets/image-20200831083610576.png)

超时了。

+ 通过深度优先搜索的方法

```java
/**
 * @author: ffzs
 * @Date: 2020/8/31 上午8:21
 */
public class Solution2 {

    List<List<Integer>> map;
    int count = 0;
    boolean[] in;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        map = rooms;
        in = new boolean[rooms.size()];
        dfs(0);
        return count==rooms.size()-1;
    }

    private void  dfs (int room) {
        List<Integer> tmp = map.get(room);
        while (tmp!=null && !tmp.isEmpty()) {
            Integer nextAirport = tmp.remove(0);
            dfs(nextAirport);
        }
        if (!in[room]) {
            in[room] = true;
            count++;
        }
    }
}
```

![image-20200831083919511](README.assets/image-20200831083919511.png)
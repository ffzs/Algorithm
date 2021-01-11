## [1202. 交换字符串中的元素](https://leetcode-cn.com/problems/smallest-string-with-swaps/)

## 题目

给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。

你可以 任意多次交换 在 pairs 中任意一对索引处的字符。

返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。

```java
示例 1:
输入：s = "dcab", pairs = [[0,3],[1,2]]
输出："bacd"
解释： 
交换 s[0] 和 s[3], s = "bcad"
交换 s[1] 和 s[2], s = "bacd"
    
示例 2：
输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
输出："abcd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[0] 和 s[2], s = "acbd"
交换 s[1] 和 s[2], s = "abcd"
    
示例 3：
输入：s = "cba", pairs = [[0,1],[1,2]]
输出："abc"
解释：
交换 s[0] 和 s[1], s = "bca"
交换 s[1] 和 s[2], s = "bac"
交换 s[0] 和 s[1], s = "abc"
```



```java
提示：

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s 中只含有小写英文字母
```


链接：https://leetcode-cn.com/problems/smallest-string-with-swaps

## 解题记录

+ 有这样一个道理就是，如果index相连的话，那么着些index上的字符都是可以更换位置的
+ 因此可以理解为，整理出index相连的情况，然后这些index组的字符进行排序之后放到对应的index上
+ 因此问题转化为分组的问题，可以通过dfs进行分组

```java
/**
 * @author: ffzs
 * @Date: 2021/1/11 下午8:23
 */
public class Solution {
    boolean[] visited;
    List<List<Integer>> lists = new ArrayList<>();
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;
        char[] cs = s.toCharArray();
        int n = cs.length;
        this.visited = new boolean[n];

        Map<Integer, List<Integer>> tmp = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            int x = pairs.get(i).get(0), y = pairs.get(i).get(1);
            if (!tmp.containsKey(x)) tmp.put(x, new ArrayList<>());
            if (!tmp.containsKey(y)) tmp.put(y, new ArrayList<>());
            tmp.get(x).add(y);
            tmp.get(y).add(x);
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                List<Integer> lst = new ArrayList<>();
                dfs(i, tmp, lst);
                lists.add(lst);
            }
        }

        char[] res = new char[n];

        for (List<Integer> list : lists) {
            char[] sub_cs = new char[list.size()];
            int[] is = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                int idx = list.get(i);
                sub_cs[i] = cs[idx];
                is[i] = idx;
            }
            Arrays.sort(sub_cs);
            Arrays.sort(is);
            for (int i = 0; i < is.length; i++) {
                res[is[i]] = sub_cs[i];
            }
        }

        return new String(res);
    }

    private void dfs (int i, Map<Integer, List<Integer>> tmp, List<Integer> lst) {
        if (visited[i]) return;
        else {
            visited[i] = true;
            lst.add(i);
            if (tmp.containsKey(i)) {
                for (int j: tmp.get(i)) {
                    if (!visited[j]) {
                        dfs(j, tmp, lst);
                    }
                }
            }
        }
    }
}
```

![image-20210111210456558](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210111210456558.png)

+ 上面的做法使用map缓存关系，比较浪费资源
+ 可以通过并查集的方法将，有关联的都指向一个father，通过这个father进行分组

```java
/**
 * @author: ffzs
 * @Date: 2021/1/11 下午8:41
 */
public class Solution2 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] father = new int[n];

        for (int i = 0; i < n; i++) {
            father[i] = i;
        }

        for (List<Integer> p : pairs) {
            merge(p.get(0), p.get(1), father);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int f = find(i, father);
            if (!map.containsKey(f)) map.put(f, new ArrayList<>());
            map.get(f).add(i);
        }

        char[] res = new char[n];
        for (List<Integer> value : map.values()) {
            char[] tmp = new char[value.size()];
            for (int i = 0; i < value.size(); i++) {
                tmp[i] = s.charAt(value.get(i));
            }

            Arrays.sort(tmp);

            for (int i = 0; i < value.size(); i++) {
                res[value.get(i)] = tmp[i];
            }
        }

        return new String(res);
    }

    private int find(int i, int[] father) {
        if (father[i] != i) father[i] = find(father[i], father);
        return father[i];
    }

    private void merge(int i, int j, int[] father) {
        father[find(i, father)] = find(j, father);
    }
}
```

![image-20210111210403018](README.assets/image-20210111210403018.png)
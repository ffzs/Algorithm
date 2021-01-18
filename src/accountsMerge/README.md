## [721. 账户合并](https://leetcode-cn.com/problems/accounts-merge/)

## 题目

给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。

```java
示例 1：

输入：
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
输出：
[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
解释：
第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
```



```java
提示：

accounts的长度将在[1，1000]的范围内。
accounts[i]的长度将在[1，10]的范围内。
accounts[i][j]的长度将在[1，30]的范围内。
```


链接：https://leetcode-cn.com/problems/accounts-merge

## 解题记录

+ 通过并查集来确定那些邮箱是指定为同一个人
+ 然后在将这些邮箱汇总

```java
 * @author: ffzs
 * @Date: 2021/1/18 下午7:37
 */

class UnionFind {
    private int[] father;

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
    }

    public int find (int i) {
        if (father[i] != i) father[i] = find(father[i]);
        return father[i];
    }

    public void union (int i, int j) {
        father[find(i)] = find(j);
    }
}

public class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();

        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!indexMap.containsKey(email)) {
                    indexMap.put(email, count++);
                    nameMap.put(email, name);
                }
            }
        }

        UnionFind uni = new UnionFind(count);

        for (List<String> account : accounts) {
            int index1 = indexMap.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                int index2 = indexMap.get(account.get(i));
                uni.union(index1, index2);
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : indexMap.entrySet()) {
            int index = uni.find(entry.getValue());
            if (!map.containsKey(index)) map.put(index, new ArrayList<>());
            map.get(index).add(entry.getKey());
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : map.values()) {
            Collections.sort(emails);
            List<String> row = new ArrayList<>();
            row.add(nameMap.get(emails.get(0)));
            row.addAll(emails);
            res.add(row);
        }
        return res;
    }
}
```

![image-20210118211844577](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210118211844577.png)
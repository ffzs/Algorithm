package largestComponentSize;

/**
 * @author: ffzs
 * @Date: 2022/7/30 下午12:24
 */

class UnionSet {
    private int[] father;
    public UnionSet(int size) {
        father = new int[size];
        for (int i = 0; i < size; i++) {
            father[i] = i;
        }
    }

    public void union(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx != fy) father[fx] = fy;
    }

    public int find (int x) {
        return father[x] == x ? x : (father[x] = find(father[x]));
    }
}

public class Solution {
    static final int n = (int)1e5 + 2;
    static int[] primes = new int[n];
    static boolean[] mark = new boolean[n];
    static int k = 0;
    static {
        for (int i = 2; i * 2 < n; i++) {
            if (!mark[i]) primes[k++] = i;
            for (int j = 0; primes[j] * i < n; j++) {
                mark[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }
    public int largestComponentSize(int[] nums) {
        UnionSet uSet = new UnionSet(n);
        for (int num : nums) {
            int it = num;
            for (int i = 0; i < k && primes[i] * primes[i] <= it; i+=1) {
                if (it % primes[i] == 0) {
                    uSet.union(num, primes[i]);
                    while (it % primes[i] == 0) it /= primes[i];
                }
            }

            if (it > 1) uSet.union(it, num);
        }

        int[] cnt = new int[n];
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, ++cnt[uSet.find(num)]);
        }
        return res;
    }

}

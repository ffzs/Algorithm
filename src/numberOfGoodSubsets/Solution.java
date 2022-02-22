package numberOfGoodSubsets;

/**
 * @author: ffzs
 * @Date: 2022/2/22 上午9:27
 */
public class Solution {
    static int[] prime = {2,3,5,7,11,13,17,19,23,29};
    static boolean[] isPow;
    static {
        isPow = new boolean[31];
        int[] pow_nums = {4,8,9,12,16,18,20,24,25,27,28};
        for (int pow_num : pow_nums) {
            isPow[pow_num] = true;
        }
    }
    static int MOD = (int)1e9 + 7;
    public int numberOfGoodSubsets(int[] nums) {
        int[] freq = new int[31];
        for (int num : nums) {
            freq[num]++;
        }
        int[] f = new int[1 << 10];
        f[0] = 1;
        for (int i = 0; i < freq[1]; i++) {
            f[0] *= 2;
            if (f[0] >= MOD) f[0] -= MOD;
        }

        for (int i = 2; i <= 30; i++) {
            if (freq[i] == 0 || isPow[i]) continue;
            int subset = 0;
            for (int j = 0; j < prime.length; j++) {
                if (i % prime[j] == 0) subset |= (1<<j);
            }

            for (int mask = (1<<prime.length) - 1; mask > 0; mask--) {
                if ((mask & subset) == subset) f[mask] = (int)((f[mask] + ((long)f[mask ^ subset] * freq[i]))%MOD);
            }
        }

        int res = 0;
        for (int i = 1, maskMax = (1<<prime.length); i < maskMax; i++) {
            res += f[i];
            if (res >= MOD) res -= MOD;
        }
        return res;
    }
}

package waysToChange;

public class waysToChange {
    public int waysToChange(int n) {
        int res = 0;
        for (int i = 0; i <= n / 25; ++i) {
            long tmp = (n - i * 25) / 10;
            res = (int)((res + (tmp + 1) * (n / 5 - i * 5 + 1 - tmp)) % 1000000007);
        }
        return res;
    }
}

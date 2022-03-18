package Bank;

/**
 * @author: ffzs
 * @Date: 2022/3/18 上午7:56
 */
public class Bank {

    long[] b;
    int n;
    public Bank(long[] balance) {
        b = balance;
        n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 <=0 || account1 > n || account2<=0||account2 > n || b[account1-1] < money) return false;
        b[account1-1] -= money;
        b[account2-1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account <= 0 || account > n) return false;
        b[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account <= 0 || account > n || b[account-1] < money) return false;
        b[account-1] -= money;
        return true;
    }

}

package fib;

/**
 * @author: ffzs
 * @Date: 2021/1/4 上午8:42
 */
public class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}

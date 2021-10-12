package fizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/10/13 上午7:07
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) res.add("FizzBuzz");
            else if (i % 5 == 0) res.add("Buzz");
            else if (i % 3 == 0) res.add("Fizz");
            else res.add(String.valueOf(i));
        }
        return res;
    }

}

package fractionToDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/10/3 上午7:06
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long num = numerator, den = denominator;
        boolean sign =(num * den) > 0;
        num = Math.abs(num);
        den = Math.abs(den);

        long before = num / den;
        long rem = num % den;

        StringBuilder res = new StringBuilder();
        if (!sign) res.append("-");
        res.append(before);
        if (rem == 0) return res.toString();
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (rem != 0 && !map.containsKey(rem)) {
            map.put(rem, index++);
            sb.append(rem * 10 /den);
            rem = rem * 10 % den;
        }
        if (rem != 0) {
            sb.insert(map.get(rem), "(").append(")");
        }
        return res.append(sb).toString();
    }

}

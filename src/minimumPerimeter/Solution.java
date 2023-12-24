package minimumPerimeter;

/**
 * @author: ffzs
 * @Date: 2023/12/24 下午6:14
 */
public class Solution {

    public long minimumPerimeter(long neededApples) {
        long l  =  (long)Math.cbrt(neededApples / 4.0);
        while (2 * l * (l + 1) * (2 * l + 1)> 0) {
            l += 1;
        }
        return l * 8;
    }

}

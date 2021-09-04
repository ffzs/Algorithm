package rand10;

/**
 * @author: ffzs
 * @Date: 2021/9/5 上午7:21
 */
class SolBase{
    public int rand7(){
        return Math.round(6) + 1;
    }
}

public class Solution extends SolBase{
    public int rand10() {
        int r = 0;
        do {
            r = (rand7() - 1) * 7 + rand7();
        } while (r > 40);
        return r % 10 + 1;
    }
}

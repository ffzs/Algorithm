package singleNumbers;

public class singleNumbers {
    public static int[] singleNumbers(int[] nums) {
        int res = 0, n1=0;
        for (int n :nums) {
            res ^= n;
        }
        int m = res&(-res);
        for (int n:nums){
            if((m&n)==0) n1^=n;
        }
        return new int[]{n1, n1^res};
    }
}

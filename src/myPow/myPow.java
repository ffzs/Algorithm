package myPow;

public class myPow {
    public static double myPow(double x, int n){
        // 任何数的0次幂都是1
        if (n==0) return 1;
        else if (n%2==1) return myPow(x, n-1) * x;
        else if (n%2==-1) return myPow(x, n+1)*(1/x);
        else {
            double tmp = myPow(x, n/2);
            return tmp*tmp;
        }
    }
}

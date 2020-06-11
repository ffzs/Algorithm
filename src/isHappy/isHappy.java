package isHappy;

public class isHappy {
    public static boolean isHappy(int n){
        n = tranNum(n);
        if (n==1) return true;
        while( true ){
            n = tranNum(n);
            if (n==1) return true;
            if (n==145) return false;
        }
    }

    private static int tranNum(int n){
        int tmp = (int)Math.pow(n%10, 2);
        int quotient=n/10;
        while(quotient != 0){
            tmp += Math.pow(quotient%10, 2);
            quotient /= 10;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(isHappy(n));
    }
}

package isHappy;

public class isHappy2 {
    public static boolean isHappy(int n){
        int slow = n;
        do{
            n = tranNum(n);
            n = tranNum(n);
            slow = tranNum(slow);
        } while( n != slow );
        return slow==1;
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

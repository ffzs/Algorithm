package generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    static int N;
    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        N = n<<1;
        char[] seq = new char[N];
        addStr(seq, 0, N, result);
        return result;
    }

    private static void addStr(char[] seq, int count, int rest, List<String> result){
        if (rest==0&&count==0){
            result.add(new String(seq));
        } else if (count>0 && rest>0){
            seq[N-rest] = '(';
            addStr(seq, count+1, rest-1, result);
            seq[N-rest] = ')';
            addStr(seq, count-1, rest-1, result);
        } else if(count==0&&rest>0){
            seq[N-rest] = '(';
            addStr(seq, count+1, rest-1, result);
        }
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}


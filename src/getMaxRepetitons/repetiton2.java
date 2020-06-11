package getMaxRepetitons;

import java.util.ArrayList;
import java.util.List;

public class repetiton2 {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int i=0,j=0,times1=0,times2=0,index=-1;
        char[] seq1=s1.toCharArray();
        char[] seq2=s2.toCharArray();
        List<Integer> tmp = new ArrayList<>();
        while (i < seq1.length*n1){
            if (i%seq1.length==0) {
                if (i!=0) tmp.add(times2);
                times1++;
                System.out.println(i +":"+times1);
            }
            if (seq2[j%seq2.length] == seq1[i%seq1.length]) {
                System.out.println(seq2[j%seq2.length]+"->"+i+":"+j);
                if(i%seq1.length==index && j%seq2.length==0 && j!=0) {
                    if(times2>tmp.get(tmp.size()-1)) tmp.add(times2);
                    System.out.println(times1+".."+ tmp.size());
                    break;
                }
                if(j%seq2.length==seq2.length-1) times2++;
                if(index==-1) index=i;
                j++;
            }
            if(i == seq1.length*n1-1) return times2/n2;
            i ++;
        }
        System.out.println(tmp);
        if (times1==0) return 0;
        if(times1!=tmp.size()){
            return n1%(times1-1)==0?n1/(times1-1)*tmp.get(tmp.size()-1)/n2:(n1/(times1-1)*tmp.get(tmp.size()-1)+tmp.get(n1%(times1-1)-1))/n2;
        }else{
            return (n1-1)/(times1-1)==0? (n1-1)/(times1-1)*tmp.get(tmp.size()-1)/n2:((n1-1)/(times1-1)*tmp.get(tmp.size()-1)+tmp.get((n1-1)%(times1-1)))/n2;
        }
    }

    public static void main(String[] args) {
//        String s1 = "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf";
//        String s2 = "xtlsgypsfa";
//        String s1 = "abcd";
//        String s2 = "dcba";
        String s1 = "abab";
        String s2 = "abba";
//        String s1 = "aaaaaa";
//        String s2 = "a";
        int n1 = 3;
        int n2 = 1;
        System.out.println(getMaxRepetitions(s1, n1, s2, n2));
    }
}

package others;

import java.util.List;

public class wordLength {
    public static int wordLenght(String seq){
        String[] seqArr = seq.split(" ");
        return seqArr[seqArr.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(wordLenght("hello world"));
    }
}

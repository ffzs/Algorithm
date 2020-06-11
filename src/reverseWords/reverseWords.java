package reverseWords;

public class reverseWords {
    public static String reverseWords(String s){
        if (s.length()==0) return s;
        StringBuilder res = new StringBuilder();
        int index = 0;
        s = "  " + s;
        for (int i=s.length()-1; i>0; --i){
            if(s.charAt(i)!=' ' && index==0){
                index = i;
            }else if(s.charAt(i)==' ' && i < index){
                res.append(s, i+1, index+1).append(" ");
                index = 0;
            }
        }
        return res.length()>0?res.deleteCharAt(res.length()-1).toString():"";
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(reverseWords(s));
    }
}

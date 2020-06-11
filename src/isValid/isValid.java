package isValid;

public class isValid {
    public static boolean isValid(String s) {
        char[] seq = s.toCharArray();
        int len = seq.length;
        if (len == 0 || len % 2 != 0) return false;
        char[] info = new char[seq.length];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (seq[i] == '('||seq[i]=='['||seq[i]=='{' ) {
                if(i==0) {info[i] = seq[i]; continue;}
                index ++;
                info[index] = seq[i];
            }else{
                if(i==0)return false;
                if((seq[i] - info[index] != 2 ) && (seq[i] - info[index] != 1)) return false;
                index--;
            }
        }
        return index == -1;
    }

    public static void main(String[] args) {
        String str = "()";
        System.out.println(isValid(str));
    }
}

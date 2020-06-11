package others;

public class trap {
    public static int trap(int[] height) {
        int counter = 0;
        for (int i=0; i<height.length-2; i++) {
            if (height[i] <= height[i+1]) continue;
            marker:for (int sub_height = height[i]; sub_height>height[i+1]; sub_height--) {
                int subCounter = 0;
                for (int j=i+1; j<height.length; j++) {
                    if (height[j]>=sub_height) {
                        counter += subCounter;
                        i = j-1;
                        break marker;
                    }
                    subCounter += sub_height - height[j];
                }
            }
        }
        return counter;
    }



    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(a));
    }
}

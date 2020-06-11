package maxArea;

public class maxArea {
    public static int maxArea(int[] height){
        int len = height.length;
        int left=0, right=len-1, maxL=0, maxR=0, res=0;
        while(left!=right){
            if (height[left] < height[right]){
                if (height[left] > maxL){res=Math.max(res, (right-left)*height[left]);}
                maxL=height[left];
                left++;
            }else{
                if (height[right] > maxR) res=Math.max(res, (right-left)*height[right]);
                maxR=height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] height = {8,10,14,0,13,10,9,9,11,11};
        int[] height = {1,2,1};
        System.out.println(maxArea(height));
    }
}

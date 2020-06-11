package findInMountainArray;

public class findInMountainArray {
    public static int findInMountainArray(int target, MountainArray mountainArr){
        int left=0, right=mountainArr.length()-1;
        while (left+1!=right){
            int mid = (left+right)>>1;
            if(mountainArr.get(mid)>mountainArr.get(mid-1)) left=mid;
            else right=mid;
        }
        int top = mountainArr.get(left)>mountainArr.get(right)?left:right;
        int leftRes = binSearch(0, top, target,mountainArr,1);
        if (leftRes!=-1) return leftRes;
        else return binSearch(top+1,mountainArr.length()-1, target,mountainArr,-1);
    }

    private static int binSearch(int left, int right, int target, MountainArray mountainArr, int asc){
        while (left <= right) {
            int mid = (left+right)>>1;
            int value = mountainArr.get(mid);
            if(value==target) return mid;
            if ((target-value)*asc>0) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
}


interface MountainArray {
    public int get(int index);
    public int length();
}
package mySqrt;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mySqrt {
    public static int mySqrt (int x) {
        if (x==0) return 0;
        else if (x<4) return 1;
        int left = 2;
        int right = x/2;

        while(left + 1 < right) {
            int num = (left + right)>>>1;
            long sq = num * num;
            if(x < sq) right = num;
            else if(x > sq) left = num;
            else if(x == sq) return num;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }
}

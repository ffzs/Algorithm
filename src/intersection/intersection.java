package intersection;

import java.util.Arrays;

public class intersection {
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int[] line1x = {Math.min(start1[0], end1[0]), Math.max(start1[0], end1[0])};
        int[] line1y = {Math.min(start1[1], end1[1]), Math.max(start1[1], end1[1])};
        int[] line2x = {Math.min(start2[0], end2[0]), Math.max(start2[0], end2[0])};
        int[] line2y = {Math.min(start2[1], end2[1]), Math.max(start2[1], end2[1])};
        double x;
        double y;
        if (line1x[0] > line2x[1] || line2x[0] > line1x[1] || line1y[0] > line2y[1] || line2y[0] > line1y[1]) return new double[]{};
        if ((start1[0]-end1[0]==0) && (start2[0]-end2[0]==0) ){
            return new double[]{(double)start1[0], (double)Math.max(line1y[0], line2y[0])};
        } else if ((start1[0]-end1[0]==0)){
            x = start1[0];
            double k2 = (start2[1]-end2[1])/(double)(start2[0]-end2[0]);
            double b2 = start2[1] - k2*start2[0];
            y = k2*x + b2;
        } else if ((start2[0]-end2[0]==0)){
            x = start2[0];
            double k1 = (start1[1]-end1[1])/(double)(start1[0]-end1[0]);
            double b1 = start1[1] - k1*start1[0];
            y = k1*x + b1;
        } else {
            double k1 = (start1[1]-end1[1])/(double)(start1[0]-end1[0]);
            double k2 = (start2[1]-end2[1])/(double)(start2[0]-end2[0]);
            double b1 = start1[1] - k1*start1[0];
            double b2 = start2[1] - k2*start2[0];
            System.out.println(k1+ ":" + k2);
            if (k1 == k2 ) {
                if (b1 == b2) {
                    x = Math.max(line1x[0], line2x[0]);
                    y = k1*x + b1;
                    return new double[]{x,y};
                }
                return new double[]{};
            }else{
                x = (b2-b1)/(k1-k2);
                y = k1*x + b1;
            }
        }

        if (x>=line1x[0] && x<=line1x[1] && x>=line2x[0] && x<=line2x[1] && y>=line1y[0] && y<=line1y[1] && y>=line2y[0] && y<=line2y[1]){
            return new double[]{x,y};
        }
        return new double[]{};
    }

    public static void main(String[] args) {
        int[] start1 = new int[]{0,0};
        int[] end1 = new int[]{0,1};
        int[] start2 = new int[]{1,0};
        int[] end2 = new int[]{1,1};
        System.out.println(Arrays.toString(intersection(start1, end1, start2, end2)));
    }
}

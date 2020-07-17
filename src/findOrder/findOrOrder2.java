package findOrder;

import java.util.ArrayList;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/17
 */
public class findOrOrder2 {

    int[] step, res;
    int count = 0;
    ArrayList<Integer>[] adjacent;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses==0) return new int[0];
        step = new int[numCourses];
        res = new int[numCourses];
        adjacent = new ArrayList[numCourses];
        for (int i = 0; i < numCourses ; i++) adjacent[i] = new ArrayList<>();

        for (int[] pr:prerequisites) adjacent[pr[0]].add(pr[1]);

        for (int i = 0; i < numCourses; i++) if (isCycle(i)) return new int[0];

        return res;
    }

    public boolean isCycle (int i) {
        if (step[i]==1) return true;
        if (step[i]==-1) return false;

        step[i] = 1;

        for (int l: adjacent[i]) if (isCycle(l)) return true;

        res[count++] = i;
        step[i] = -1;

        return false;
    }
}

//class test {
//    public static void main(String[] args) {
//        findOrOrder2 f = new findOrOrder2();
//        int[][] prerequis
//        System.out.println(f.findOrder());
//    }
//}
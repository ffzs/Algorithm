package maxAverageRatio;

import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2023/2/19 上午9:31
 */
class Item {
    int a;
    int b;
    double c;
    Item (int a, int b) {
        this.a = a;
        this.b = b;
        this.c = (double) (a+1)/(b+1) - (double) a/b;
    }
    public void update() {
        this.a += 1;
        this.b += 1;
        this.c = (double) (a+1)/(b+1) - (double) a/b;
    }
    @Override
    public String toString () {
        return a + ":" + b + ":" + c;
    }
}
public class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Item> q = new PriorityQueue<>((a, b) -> {
            if(a.c == b.c) return 0;
            else if (a.c < b.c) return 1;
            return -1;
        });
        for (int[] it : classes) {
            q.offer(new Item(it[0], it[1]));
        }
        for (int i = 0; i < extraStudents; i++) {
            Item it = q.poll();
            it.update();
            q.offer(it);
        }
        double res = 0;
        Item tmp;
        while (!q.isEmpty()) {
            tmp = q.poll();
            res += (double) tmp.a / tmp.b;
        }
        return res / classes.length;
    }

}

package StockPrice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/1/23 上午9:09
 */
public class StockPrice {
    int recent, recentTime;
    Map<Integer, Integer> map;
    PriorityQueue<int[]> minPq;
    PriorityQueue<int[]> maxPq;

    public StockPrice() {
        recent = -1;
        recentTime = -1;
        map = new HashMap<>();
        minPq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        maxPq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    }


    public void update(int timestamp, int price) {
        if (timestamp >= recentTime) {
            recentTime = timestamp;
            recent = price;
        }
        map.put(timestamp, price);
        minPq.offer(new int[] {timestamp, price});
        maxPq.offer(new int[] {timestamp, price});
    }

    public int current() {
        return recent;
    }

    public int maximum() {
        int ret = 0;
        while (!maxPq.isEmpty()) {
            int[] cur = maxPq.peek();
            if (map.get(cur[0]) != cur[1]) {
                maxPq.poll();
            }
            else {
                ret = cur[1];
                break;
            }
        }
        return ret;
    }

    public int minimum() {
        int ret = 0;
        while (!minPq.isEmpty()) {
            int[] cur = minPq.peek();
            if (map.get(cur[0]) != cur[1]) {
                minPq.poll();
            }
            else {
                ret = cur[1];
                break;
            }
        }
        return ret;
    }

}

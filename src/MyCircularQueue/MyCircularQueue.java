package MyCircularQueue;

/**
 * @author: ffzs
 * @Date: 2022/8/2 上午10:27
 */
public class MyCircularQueue {
    int[] queue;
    int k, head, tail, cnt;
    public MyCircularQueue(int k) {
        queue = new int[k];
        this.k = k;
        head = -1;
        tail = 0;
        cnt = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        cnt += 1;
        queue[++head%k] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        cnt -= 1;
        tail += 1;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[tail%k];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[head%k];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }
}

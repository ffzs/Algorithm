package MyCircularDeque;

/**
 * @author: ffzs
 * @Date: 2022/8/15 上午10:19
 */
public class MyCircularDeque {
    static class Node {
        Node pro;
        Node suf;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    int k, cnt;
    Node head, tail;
    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.suf = tail;
        tail.pro = head;
        this.k = k;
        cnt = 0;
    }

    public boolean insertFront(int value) {
        if (cnt >= k) return false;
        Node cur = new Node(value);
        cur.suf = head.suf;
        cur.pro = head;
        head.suf.pro = cur;
        head.suf = cur;
        cnt += 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (cnt >= k) return false;
        Node cur = new Node(value);
        cur.pro = tail.pro;
        cur.suf = tail;
        tail.pro.suf = cur;
        tail.pro = cur;
        cnt += 1;
        return true;
    }

    public boolean deleteFront() {
        if (cnt <= 0) return false;
        head.suf.suf.pro = head;
        head.suf = head.suf.suf;
        cnt -= 1;
        return true;
    }

    public boolean deleteLast() {
        if (cnt <= 0) return false;
        tail.pro.pro.suf = tail;
        tail.pro = tail.pro.pro;
        cnt -= 1;
        return true;
    }

    public int getFront() {
        if (cnt == 0) return -1;
        return head.suf.val;
    }

    public int getRear() {
        if (cnt == 0) return -1;
        return tail.pro.val;
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }

}

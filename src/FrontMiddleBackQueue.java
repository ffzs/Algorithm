import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2023/11/28 上午8:34
 */
public class FrontMiddleBackQueue {
    Deque<Integer> pre, back;
    public FrontMiddleBackQueue() {
        pre = new LinkedList<>();
        back = new LinkedList<>();
    }

    public void pushFront(int val) {
        pre.addFirst(val);
    }

    private void shuffle () {
        while(!back.isEmpty() && pre.size() < back.size()-1) {
            pre.addLast(back.pollFirst());
        }

        while(pre.size() > back.size()) {
            back.addFirst(pre.pollLast());
        }
    }

    public void pushMiddle(int val) {
        shuffle();
        pre.addLast(val);
    }

    public void pushBack(int val) {
        back.addLast(val);
    }

    public int popFront() {
        if (pre.size() > 0) return pre.pollFirst();
        else if(back.size() > 0) return back.pollFirst();
        else return -1;
    }

    public int popMiddle() {
        shuffle();
        if (back.isEmpty() && pre.isEmpty()) return -1;
        else if (back.size() > pre.size()) return back.pollFirst();
        return pre.pollLast();
    }

    public int popBack() {
        if (back.size() > 0) return back.pollLast();
        else if (pre.size() > 0) return pre.pollLast();
        else return -1;
    }

}

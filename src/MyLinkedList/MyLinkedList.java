package MyLinkedList;

/**
 * @author: ffzs
 * @Date: 2022/9/23 下午12:47
 */
public class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }
    Node head, tail;
    int size;
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index >= size) return -1;
        return getNode(index).val;
    }

    private Node getNode (int index) {
        int i;
        Node cur;
        if (index < size - index - 1) {
            i = 0;
            cur = head;
            while (i <= index) {
                cur = cur.next;
                i += 1;
            }
        }
        else {
            i = size - 1;
            cur = tail;
            while (i >= index) {
                cur = cur.prev;
                i -= 1;
            }
        }
        return cur;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size += 1;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            Node cur = getNode(index);
            Node node = new Node(val);
            node.prev = cur.prev;
            node.next = cur;
            cur.prev.next = node;
            cur.prev = node;
            size += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        Node cur = getNode(index), pre = cur.prev, suf = cur.next;
        cur.next = null;
        cur.prev = null;
        pre.next = suf;
        suf.prev = pre;
        size -= 1;
    }

}

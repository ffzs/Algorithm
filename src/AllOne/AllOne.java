package AllOne;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/3/16 上午7:57
 *  十字链表
 */
public class AllOne {

    class Node {
        int val;
        Set<String> set;
        Node pre, suf;
        Node (int v) {
            val = v;
            set = new HashSet<>();
        }
    }

    Map<String, Node> map;
    Node head, tail;
    public AllOne() {
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.suf = tail;
        tail.pre = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            var cur = map.get(key);
            cur.set.remove(key);
            int val = cur.val;
            addNode(cur, val+1, key);
            clearNode(cur);
        }
        else {
            addNode(head, 1, key);
        }
    }

    private void addNode (Node preNode, int val, String key) {
        Node cur;
        if (preNode.suf.val == val) cur = preNode.suf;
        else {
            cur = new Node(val);
            cur.suf = preNode.suf;
            cur.pre = preNode;
            preNode.suf.pre = cur;
            preNode.suf = cur;
        }
        cur.set.add(key);
        map.put(key, cur);
    }

    private void delNode (Node sufNode, int val, String key) {
        Node cur;
        if (sufNode.pre.val == val) cur = sufNode.pre;
        else {
            cur = new Node(val);
            cur.suf = sufNode;
            cur.pre = sufNode.pre;
            sufNode.pre.suf = cur;
            sufNode.pre = cur;
        }
        cur.set.add(key);
        map.put(key, cur);
    }

    private void clearNode(Node node) {
        if (node.set.size() == 0) {
            node.pre.suf = node.suf;
            node.suf.pre = node.pre;
        }
    }

    public void dec(String key) {
        Node cur = map.get(key);
        cur.set.remove(key);
        int val = cur.val;
        if (val == 1) map.remove(key);
        else delNode(cur, val - 1, key);
        clearNode(cur);
    }

    public String getMaxKey() {
        Node cur = tail.pre;
        return cur.set.size() > 0 ? cur.set.iterator().next(): "";
    }

    public String getMinKey() {
        Node cur = head.suf;
        return cur.set.size() > 0 ? cur.set.iterator().next(): "";
    }

}

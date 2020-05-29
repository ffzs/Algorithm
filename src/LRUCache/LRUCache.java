package LRUCache;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> cache;
    private Integer cap;
    private Node tail = new Node(-1, -1);
    private Node head = new Node(-1, 1);


    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Node>(capacity);
        cap = capacity;
        this.head.suf = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }else{
            Node node = cache.get(key);
            refresh(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            refresh(node);
        }else {
            if(cache.size() == cap){
                cache.remove(tail.pre.key);
                Node removedPreNode = tail.pre.pre;
                removedPreNode.suf = tail;
                tail.pre = removedPreNode;
            }
            Node addNode = new Node(key,value);
            cache.put(key, addNode);
            head.suf.pre = addNode;
            addNode.suf = head.suf;
            head.suf = addNode;
            addNode.pre = head;
        }
    }

    public void refresh(Node node){
        node.pre.suf = node.suf;
        node.suf.pre = node.pre;
        head.suf.pre = node;
        node.suf = head.suf;
        head.suf = node;
        node.pre = head;
    }
}

class Node {
    int key;
    int value;
    Node pre = null;
    Node suf = null;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", pre=" + pre +
                '}';
    }
}

class test {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
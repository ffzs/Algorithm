package others;

import java.util.HashMap;

public class LFUCache {
    HashMap<Integer, Node> cache;
    private Integer cap;
    Node tail = new Node(-1, -1, Integer.MIN_VALUE);
    Node head = new Node(1, 1, Integer.MAX_VALUE);


    public LFUCache(int capacity) {
        cache = new HashMap<Integer, Node>(capacity);
        cap = capacity;
        this.head.suf = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if (cap <= 0 || !cache.containsKey(key)){
            return -1;
        }else{
            Node node = cache.get(key);
            node.freq++;
            refresh(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (cap > 0){
            if (cache.containsKey(key)){
                Node node = cache.get(key);
                node.value = value;
                node.freq ++ ;
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
                addNode.pre = tail.pre;
                addNode.suf = tail;
                tail.pre.suf = addNode;
                tail.pre = addNode;
                refresh(addNode);
            }
        }else{
            System.out.println("capacity smaller then 1");
        }
    }

    public void refresh(Node node){
        Node preNode = node.pre;
        Node sufNode = node.suf;
        if (preNode.freq <= node.freq) {
            preNode.suf = sufNode;
            sufNode.pre = preNode;
            System.out.println(preNode);
            while (preNode.freq <= node.freq) {
                preNode = preNode.pre;
            }
            sufNode = preNode.suf;
            preNode.suf = sufNode.pre = node;
            node.pre = preNode;
            node.suf = sufNode;
        }
    }
}

class Node {
    int key;
    int value;
    int freq = 0;
    Node pre = null;
    Node suf = null;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }

    public String toString(){
        return this.key+":"+this.value+":"+this.freq;
    }
}

class test{
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1,1);
        lfu.put(2,2);
        lfu.get(1);
        lfu.put(3,3);
        lfu.get(2);
        lfu.get(3);
        lfu.put(4,4);
        lfu.get(1);
        lfu.get(3);
        lfu.get(4);
//        System.out.println(lfu.get(2));
    }
}

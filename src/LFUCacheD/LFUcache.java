package LFUCacheD;

import java.util.HashMap;

public class LFUcache {
    HashMap<Integer, Node> cache;
    HashMap<Integer, DuLinkList> freqMap;
    private Integer cap;
    int minFreq = -1;

    public LFUcache(int capacity){
        cache = new HashMap<>(capacity);
        cap = capacity;
        freqMap = new HashMap<>();
        freqMap.put(0,new DuLinkList(0));
    }

    public int get(int key){
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        refresh(node);
        System.out.println(node);
        return node.value;
    }

    public void put(int key, int value){
        if (cap != 0){
            if (cache.containsKey(key)){
                Node node = cache.get(key);
                node.value = value;
                refresh(node);
            }else{
                System.out.println(minFreq);
                if (cache.size() == cap) {
                    DuLinkList minLst = freqMap.get(minFreq);
                    System.out.println(minLst.size());
                    Node deNode = minLst.popNode();
                    System.out.println("deNode:"+deNode);
                    cache.remove(deNode.key);
                }
                Node newNode = new Node(key,value);
                System.out.println("newNode"+newNode);
                cache.put(key,newNode);
                freqMap.get(0).addNode(newNode);
                minFreq = 0;
            }
        }
    }

    public void refresh(Node node){
        int freq = node.freq;
        DuLinkList lst = freqMap.get(freq);
        freqMap.get(freq).removeNode(node);
        if (freq==minFreq && lst.size()==0){
            minFreq ++;
        }
        node.freq++;
        if (!freqMap.containsKey(freq+1)) freqMap.put(freq+1, new DuLinkList(freq+1));
        freqMap.get(freq+1).addNode(node);
    }

}


class DuLinkList {
    int freq;
    Node head = new Node(1,1);
    Node tail = new Node(-1,-1);

    public DuLinkList() {}

    public DuLinkList(int freq) {
        this.freq = freq;
        head.suf = tail;
        tail.pre = head;
    }

    public void addNode(Node node) {
        head.suf.pre = node;
        node.suf = head.suf;
        node.pre = head;
        head.suf = node;
        head.freq++;
    }

    public void removeNode(Node node) {
        node.pre.suf = node.suf;
        node.suf.pre = node.pre;
        head.freq--;
    }

    public Node popNode() {
        Node deleteNode = tail.pre;
        tail.pre = tail.pre.pre;
        tail.pre.suf = tail;
        head.freq--;
        return deleteNode;
    }

    public int size() {
       return this.head.freq;
    }
}


class Node {
    int key;
    int value;
    int freq = 0;
    Node pre;
    Node suf;

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
        LFUcache lfu = new LFUcache(2);
        lfu.put(3,1);
        lfu.put(2,1);
        lfu.put(2,2);
        lfu.put(4,4);
//        lfu.put(1,1);
//        lfu.put(2,2);
//        lfu.get(1);
//        lfu.put(3,3);
//        lfu.get(2);
//        lfu.get(3);
//        lfu.put(4,4);
//        lfu.get(1);
//        lfu.get(3);
        lfu.get(2);
//        System.out.println(lfu.get(2));
    }
}
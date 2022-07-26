package Skiplist;

/**
 * @author: ffzs
 * @Date: 2022/7/26 上午9:38
 */
public class Skiplist {

    class Node {
        int value;
        Node[] next;

        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }
    }

    private static int MAX_LEVEL = 32;
    private static double P_FACTOR = 0.25;

    Node head;
    int curMaxLevel;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        curMaxLevel = 1;
    }

    private static int randomLevel () {
        int level = 1;
        while (Math.random() < P_FACTOR && level < MAX_LEVEL) {
            level += 1;
        }
        return level;
    }

    private Node findClosest (Node node, int level, int value) {
        while ((node.next[level]) != null && value > node.next[level].value) {
            node = node.next[level];
        }
        return node;
    }

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = curMaxLevel-1; i >= 0; i-=1) {
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i] != null && searchNode.next[i].value == target) return true;
        }
        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        for (int i = curMaxLevel-1; i >= 0; i-=1) {
            updateNode = findClosest(updateNode, i, num);
            if (i < level) {
                if (updateNode.next[i] == null) updateNode.next[i] = newNode;
                else {
                    Node t = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = t;
                }
            }
        }

        if (level > curMaxLevel) {
            for (int i = curMaxLevel; i < level; i += 1) head.next[i] = newNode;
            curMaxLevel = level;
        }
    }

    public boolean erase(int num) {
        boolean ret = false;
        Node searchNode = head;
        for (int i = curMaxLevel-1; i >= 0; i-=1) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                searchNode.next[i] = searchNode.next[i].next[i];
                ret = true;
            }
        }
        return ret;
    }

}

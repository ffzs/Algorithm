package alienOrder;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/5/31 上午9:01
 */
public class Solution {

    static class Node {
        Node[] children;
        int order;
        int cnt;
        boolean isEnd;

        public Node(int order) {
            children = new Node[26];
            this.order = order;
            this.cnt = 0;
            isEnd = false;
        }
    }

    static class TrieTree {
        Node root;
        private boolean isValid;
        private int idx;

        public TrieTree() {
            this.root = new Node(-1);
            isValid = true;
        }

        public boolean insert (String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node(cur.cnt++);
                else if (cur.children[c - 'a'].order != cur.cnt - 1) return false;
                else if (i == s.length()-1 && !cur.children[c - 'a'].isEnd) return false;
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
            return true;
        }

        public String inOrder () {
            int[][] connection = new int[26][26];
            int[] state = new int[26];
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Set<Integer> set = new HashSet<>();
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node cur = q.poll();
                    if (cur.cnt == 0) continue;
                    else {
                        List<int[]> lst = new ArrayList<>();
                        for (int j = 0; j < 26; j++) {
                            Node sub = cur.children[j];
                            if (sub != null) {
                                set.add(j);
                                q.offer(sub);
                                lst.add(new int[]{j, sub.order});
                            }
                        }
                        if (lst.size() != 1) {
                            lst.sort((a, b) -> a[1] - b[1]);
                            for (int a = 0; a < lst.size(); a++) {
                                for (int b = a + 1; b < lst.size(); b++) {
                                    int x = lst.get(a)[0], y = lst.get(b)[0];
                                    if (connection[x][y] == 1) return "";
                                    connection[x][y] = -1;
                                    connection[y][x] = 1;
                                }
                            }
                        }
                    }
                }
            }
            idx = set.size()-1;
            int[] order = new int[set.size()];
            for (int it : set) {
                if (state[it] == 0) dfs(connection, it, state, order);
            }
            if (!isValid) return "";
            StringBuilder sb = new StringBuilder();
            for (int i : order) {
                sb.append((char) (i + 'a'));
            }
            return sb.toString();
        }
        // 1: 访问 2：完成访问
        private void dfs (int[][] connection, int c, int[] state, int[] order) {
            state[c] = 1;
            for (int i = 0; i < 26; i++) {
                if (connection[c][i] == -1) {
                    if (state[i] == 0) {
                        dfs(connection, i, state, order);
                        if (!isValid) return;
                    }
                    else if (state[i] == 1) {
                        isValid = false;
                        return;
                    }
                }
            }
            state[c] = 2;
            order[idx--] = c;
        }
    }

    public String alienOrder(String[] words) {
        TrieTree trieTree = new TrieTree();
        for (String word : words) {
            if (!trieTree.insert(word)) return "";
        }

        return trieTree.inOrder();
    }
}

class Test {
    public static void main(String[] args) {
        String[] ss = {"aac","aabb","aaba"};
        Solution s = new Solution();
        System.out.println(s.alienOrder(ss));
    }
}
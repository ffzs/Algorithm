package recoverFromPreorder;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/18
 */
public class Solution {
    public static TreeNode recoverFromPreorder(String S) {
        Map<Integer, TreeNode> map = new HashMap<>();
        char[] seq = S.toCharArray();
        int count = 0;
        int num = 0;
        for (int i=0 ; i< seq.length; ++i) {
            char c = seq[i];
            if ( seq[i] == '-') {
                count ++;
            }else{
                num = num*10 + ( c - '0');
                System.out.println(num);
                if (i == seq.length-1 || seq[i+1] == '-'){
                    TreeNode node = new TreeNode(num);
                    map.put(count, node);
                    if (map.containsKey(count-1)){
                        TreeNode preNode = map.get(count-1);
                        if (preNode.left != null) preNode.right = node;
                        else preNode.left = node;
                    }
                    num = 0;
                    count = 0;
                }
            }
        }
        return map.get(0);
    }


    public static void main(String[] args) {
        String s = "1-401--349---90--88";
        System.out.println(recoverFromPreorder(s));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
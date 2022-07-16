package intersect2;

/**
 * @author: ffzs
 * @Date: 2022/7/15 上午8:45
 */
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }

    public Node(boolean _val,boolean _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = null;
        topRight = null;
        bottomLeft = null;
        bottomRight = null;
    }

};

public class Solution {

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) return new Node(true, true);
            else return copy(quadTree2);
        }

        if (quadTree2.isLeaf) {
            if (quadTree2.val) return new Node(true, true);
            else return copy(quadTree1);
        }

        Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (tl.isLeaf && tr.isLeaf && br.isLeaf && bl.isLeaf && tl.val == tr.val && bl.val == br.val && tl.val == bl.val) {
            return new Node(tl.val, true);
        }

        return new Node(false, false, tl, tr, bl, br);
    }

    private Node copy(Node node) {
        return new Node(node.val, node.isLeaf, node.topLeft, node.topRight, node.bottomLeft, node.bottomRight);
    }

}

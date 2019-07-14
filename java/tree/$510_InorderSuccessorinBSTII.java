/**
 * p的中序后继有两种情况：1.当p的右节点存在时，右子树的最小节点就是结果；2.如果p的右节点不存在，则向上查找父节点，返回第一个左节点的父节点
 */
public class $510_InorderSuccessorinBSTII {
    public Node inorderSuccessor(Node p) {
        if (p == null) return null;
        //1.判断右节点是否存在
        if (p.right != null) {
            //右子树的最小节点是树的最左节点
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        //2.如果右节点不存在，则向上查找第一个左节点的父节点
        while (p != null) {
            if (p.parent == null) return null;
            if (p == p.parent.left) return p.parent;
            p = p.parent;
        }
        return p;
    }
}

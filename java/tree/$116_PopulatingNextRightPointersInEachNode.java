/**
 * 自顶向下，因为给出的是完美二叉树，所有的节点都是满的，于是，当前节点的左孩子的next为当前节点的右孩子，如果当前节点还有兄弟节点，
 * 则当前节点右孩子的next节点为兄弟节点的左节点，如果当前节点没有兄弟节点则next指向Null
 */
public class $116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        //判断左孩子是否为null
        if (root.left != null) {
            //一定有右孩子
            root.left.next = root.right;
            //判断是否有兄弟节点
            if (root.next != null) {
                //右孩子的next为兄弟节点的左孩子
                root.right.next = root.next.left;
            }
        }
        //自顶向下
        connect(root.left);
        connect(root.right);
        return root;
    }
}

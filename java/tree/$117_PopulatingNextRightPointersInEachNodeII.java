/**
 * 自顶向上递归构建next，分为以下几步：
 * 1.构建当前节点的左节点：
 *  1.1 如果root有左节点和右节点，则左节点的Next为右节点
 *  1.2 如果root右节点为Null，则查找父节点的兄弟节点的最左边子元素
 * 2.构建当前节点的右节点：
 *  2.1 如果root右节点不为Null，则next为父节点的兄弟节点的最左边子元素
 * 3.递归：这里注意一定要先构建右子树，再构建左子树，因为寻找父节点的兄弟节点是从左到右遍历的，如果右子树未构建好就遍历，则会出错
 */
public class $117_PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        //自顶向上递归
        if(root == null) return null;

        //构建当前节点的左节点
        if(root.left != null){
            //1.如果root有左节点和右节点，则左节点的Next为右节点
            if(root.right != null) root.left.next = root.right;
                //2.如果root右节点为Null，则查找父节点的兄弟节点的最左边子元素
            else root.left.next = findLeftChild(root);
        }

        //构建当前节点的右节点
        if(root.right != null)
            //如果root右节点不为Null，则next为父节点的兄弟节点的最左边子元素
            root.right.next = findLeftChild(root);

        //递归
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node findLeftChild(Node root){
        while(root.next != null){
            if(root.next.left != null) return root.next.left;
            if(root.next.right != null) return root.next.right;
            root = root.next;
        }
        return null;
    }
}

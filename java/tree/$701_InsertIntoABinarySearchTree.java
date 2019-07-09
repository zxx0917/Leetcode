/**
 * 递归结束的条件：到达最后一层的目标节点时直接返回新节点
 * 因为这里只插入一个节点，所以要不是左子树改变，要不是右子树数改变，
 * 根据BST的性质找到插入点的位置即可
 */
public class $701_InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        //根据BST的性质找到需要插入的点
        if(root.val > val){
            root.left =  insertIntoBST(root.left,val);
        }else{
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}

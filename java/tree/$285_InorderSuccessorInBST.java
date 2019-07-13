/**
 * 因为BST中序遍历的结果是节点升序，所以进行中序遍历找到P节点后遍历的下一个节点就是顺序后继节点
 * 由题意可知，顺序后继节点可能有两种情况：
 * 1.P是最后一个节点，顺序后继为null
 * 2.P不是最后一个节点，顺序后继为P中序遍历之后的第一个节点
 * 所以设定一个boolean指示是否找到P节点，并由boolean遍历的值来确定后继节点属于上述情况的哪种
 */
public class $285_InorderSuccessorInBST {
    //中序遍历，找到P节点后遍历的下一个节点就是顺序后继节点
    TreeNode res;
    boolean findP = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        helper(root, p);
        //判断p是否是最后一个节点
        if (findP) res = null;
        return res;
    }

    private void helper(TreeNode root, TreeNode p) {
        if (root == null) return;
        helper(root.left, p);
        //如果已经找到p，则遍历的下一个节点为res
        if (findP) {
            res = root;
            findP = false;
            return;
        }
        //判断当前节点是否是p
        if (root == p) {
            findP = true;
        }
        helper(root.right, p);
    }
}

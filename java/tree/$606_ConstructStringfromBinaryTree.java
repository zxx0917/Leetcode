/**
 * 由题意可知，在前序遍历时，如果当前节点的为父节点的右孩子，且该父节点的左孩子为null，则括号不能省略，所以在前序遍历时，
 * 记录当前节点的父节点，如果当前节点的父节点的左孩子为null，在StringBuilder中添加()，其余情况下直接添加(和当前节点值。
 * 注意在当前节点遍历完成后需要关闭括号。
 */
class Solution {
    //前序遍历
    TreeNode pre = null;

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(t, pre, sb);
        return sb.substring(1, sb.length() - 1);
    }

    private void helper(TreeNode root, TreeNode pre, StringBuilder sb) {
        if (root == null) return;
        //前序遍历
        //1.如果当前节点为父节点的右子树且左子树为空，括号不能省略
        if (pre != null && pre.left == null && pre.right == root) {
            sb.append("()");
        }
        sb.append("(").append(root.val);
        pre = root;
        helper(root.left, pre, sb);
        helper(root.right, pre, sb);
        //遍历完当前节点后关闭括号
        sb.append(")");
    }
}

public class $606_ConstructStringfromBinaryTree {
}

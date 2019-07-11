import java.util.Stack;

/**
 * BST的中序遍历结果为升序，可以在遍历时比较当前元素是否是现有元素的最大值，否则返回false。也可以获取前一个元素，BST的当前元素一定要大于前一个元素
 */
public class $98_ValidateBinarySearchTree {
    //1.递归
    long max = Long.MIN_VALUE;

    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        //递归结束条件
        boolean flagLeft = isValidBST1(root.left);
        if (root.val > max) {
            max = root.val;
        } else {
            return false;
        }
        boolean flagRight = isValidBST1(root.right);
        return flagLeft && flagRight;
    }

    //2.迭代
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long max = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.val <= max)
                    return false;
                max = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}

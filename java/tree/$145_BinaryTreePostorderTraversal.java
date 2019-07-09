import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 这里的迭代法使用栈来记录遍历轨迹，并使用一个变量来储存上一次访问的元素，当当前元素左右儿子为空或当前元素已经在上一轮访问过
 * （即上一次方法访问的元素为当前访问元素的节点），则栈顶元素出栈，否则继续压栈，注意先右后左
 */
public class $145_BinaryTreePostorderTraversal {
    //递归：
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }


    //迭代：
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))) {
                //加入结果集
                res.add(cur.val);
                pre = cur;
                stack.pop();
            } else {
                //继续压栈，注意先右再左。
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return res;
    }
}

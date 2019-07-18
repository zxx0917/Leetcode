import java.util.Stack;

/**
 * 字符串输出的规律为root.val(root.left.val)(root.right.val)，遵循前序遍历，所以创建一个Stack来储存节点。
 * 遍历字符串，如果遇到了数字，则创建节点，如果stack不为空，则获取顶层元素，如果顶层元素的左子树为null，则当前节点为顶层元素的左子树
 * 如果顶层元素左子树不为Null，则将当前节点连接在右子树，当遇到")"弹出stack顶层元素，直到字符串遍历完。
 * 这里需要注意节点可能为负值。
 */
class Solution {

    public TreeNode str2tree(String s) {
        if (s == null && s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') stack.pop();
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                int start = i;
                //找到根元素的值
                while (i < s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                TreeNode root = new TreeNode(Integer.valueOf(s.substring(start, i + 1)));
                //获取父节点
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) parent.left = root;
                    else parent.right = root;
                }

                //压栈
                stack.push(root);
            }
        }
        if (stack.isEmpty()) return null;
        return stack.peek();
    }
}

public class $536_ConstructBinaryTreefromString {
}

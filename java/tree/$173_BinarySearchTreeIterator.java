import java.util.Stack;

/**
 * 因为题目的空间复杂度要求为O(h)，所以在中序遍历时不将所有的元素放入集合，而是先将整颗树的最左边元素压入栈，栈顶元素
 * 就是最小值，调用next时弹出栈顶元素，并判断当前元素是否有右子树，因为BST的特征，当前元素的右子树大于当前元素，所以如果有右子树，则将右子树所有元素压入栈中
 */
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        //将所有最左边节点压栈
        stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        //最小值就是栈顶元素
        int res = cur.val;
        //判断栈顶元素是否还有右子树
        cur = cur.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}


public class $173_BinarySearchTreeIterator {
}

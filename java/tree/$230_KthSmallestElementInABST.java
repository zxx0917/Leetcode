import java.util.Stack;

/**
 * 中序遍历，使用Stack保存节点，首先将所有最左边元素压入栈中，栈顶元素就是最小元素，定义计数器，每弹出一个元素计数器+1，
 * 如果当前元素还有右子树，则按照相同规则将右子树元素压入栈中
 */
public class $230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //最左边元素压入栈中
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.add(cur);
                cur = cur.left;
            }else{
                //弹栈，计数
                cur = stack.pop();
                if(--k == 0){
                    return cur.val;
                }
                //处理右子树
                cur = cur.right;
            }
        }
        return 0;
    }
}

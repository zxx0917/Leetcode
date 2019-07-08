import java.util.Stack;

public class $156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        //将树所有的左节点压入栈中
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur.left != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode newRoot = cur;
        //cur为最左节点，即为新建Tree的父节点
        while(!stack.isEmpty()){
            //原左节点的父节点
            TreeNode parent = stack.pop();
            //原左节点父节点的右节点
            TreeNode left = parent.right;

            cur.left = left;
            cur.right = parent;
            parent.left = null;
            parent.right = null;
            cur = parent;
        }

        return newRoot;
    }
}

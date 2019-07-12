import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class $144_BinaryTreePreorderTraversal {
    //1.递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }

    //2.迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
            if(cur != null){
                res.add(cur.val);
                stack.add(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $102_BinaryTreeLevelOrderTraversal {
    //1.迭代：
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count-- > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                //注意先左后右
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(list);
        }

        return res;
    }

    //2.递归
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        helper(root.left, depth + 1, res);
        helper(root.right, depth + 1, res);
    }
}

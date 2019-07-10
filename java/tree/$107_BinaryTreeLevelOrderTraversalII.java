import java.util.*;

public class $107_BinaryTreeLevelOrderTraversalII {
    //1.迭代翻转
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
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
        Collections.reverse(res);
        return res;
    }

    //2.递归翻转
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,0,res);
        Collections.reverse(res);
        return res;
    }

    private void helper(TreeNode root, int depth, List<List<Integer>> res) {
        if(root == null) return;
        if(depth + 1 > res.size()){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        helper(root.left,depth+1,res);
        helper(root.right,depth+1,res);
    }
}

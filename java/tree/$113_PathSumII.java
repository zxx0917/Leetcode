import java.util.ArrayList;
import java.util.List;

/**
 * 1.dfs，在递归时传入一个List用于保存当前路径元素，如果已经到达叶子节点且sum = root.val时将该路径元素集加入结果集
 */
public class $113_PathSumII {
    //1.递归
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,sum,new ArrayList<>(),res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<>(list));
        }
        helper(root.left,sum-root.val,list,res);
        helper(root.right,sum-root.val,list,res);
        //回退
        list.remove(list.size()-1);
    }
}

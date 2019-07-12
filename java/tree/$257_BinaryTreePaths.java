import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历，递归时传入一个List用于储存当前路径的元素值，当到达叶子节点时，使用StringBuilder将节点值转换为目标形式，加入结果集
 * 注意每次遍历结束后需要将当前节点值在路径结果集中取出。
 */
public class $257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, new ArrayList<>(), res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> list, List<String> res) {
        if (root == null) return;
        //如果到达叶子节点，加入结果集
        list.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for(int num : list){
                sb.append(num).append("->");
            }
            //->是两个字符
            res.add(sb.substring(0,sb.length()-2));
        }
        helper(root.left, list, res);
        helper(root.right, list, res);
        //回退，将递归完的结果删除
        list.remove(list.size()-1);
    }
}

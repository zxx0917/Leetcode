import java.util.ArrayList;
import java.util.List;

/**
 * 对于第i个节点，左子树为[1,i-1]的所有可能子树，右子树为[i+1,n]的所有可能子树，当前节点所组成的二叉树总数为左子树*右子树数
 */
public class $95_UniqueBinarySearchTreesII { public List<TreeNode> generateTrees(int n) {
    if (n == 0) return new ArrayList<>();
    return helper(1, n);
}

    /**
     * 递归方法，返回当前元素返回内所有可能树的结果集
     *
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        //返回条件
        if (start > end){
            res.add(null);
            return res;
        }

        //遍历，获取每个节点为根节点的所有可能子树
        for(int i = start;i <= end;i++){
            //获取左子树集合
            List<TreeNode> leftList = helper(start,i-1);
            //获取右子树集合
            List<TreeNode> rightList = helper(i+1,end);

            //遍历两个集合，组合树
            for(TreeNode left : leftList){
                for(TreeNode right:rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    //加入结果集
                    res.add(root);
                }
            }
        }
        return res;
    }

}

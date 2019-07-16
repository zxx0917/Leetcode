import java.util.ArrayList;
import java.util.List;

/**
 * 使用dsf遍历树，遇到叶子节点时将值加入结果集，然后比较root1和root2的叶子序列即可
 */
class Solution {
    List<Integer> root1List = new ArrayList<>();
    List<Integer> root2List = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        helper(root1,root1List);
        helper(root2,root2List);
        //比较两个结果集
        if(root1List.size() != root2List.size()) return false;
        else {
            for(int i = 0;i < root1List.size();i++){
                if(root1List.get(i) != root2List.get(i))
                    return false;
            }
        }
        return true;
    }

    private void helper(TreeNode root, List<Integer> rootList) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            //到达叶子节点
            rootList.add(root.val);
        }
        helper(root.left,rootList);
        helper(root.right,rootList);
    }
}

public class $872_LeafSimilarTrees {
}

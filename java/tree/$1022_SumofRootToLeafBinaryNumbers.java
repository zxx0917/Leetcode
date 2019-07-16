/**
 * 定义一个全局变量来保存每条路径和，使用dfs找寻每条路径，到达叶子节点时将路径转换为十进制加入全局变量即可。
 * 这里十进制的转化采用了位运算，将上一次递归的累加数左移一位并或上当前节点值就是当前节点的二进制值，如果到达叶子节点直接将二进制值加入全局变量
 */
class Solution {
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        helper(root,0);
        return res;
    }

    private void helper(TreeNode root,int val) {
        if(root == null) return;
        int newVal = val << 1 | root.val;
        if(root.left == null && root.right == null){
            //到达叶子节点
            res += newVal;
        }
        helper(root.left,newVal);
        helper(root.right,newVal);
    }
}

public class $1022_SumofRootToLeafBinaryNumbers {
}

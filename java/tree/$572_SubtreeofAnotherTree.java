class Solution {
    //两个dfs，第一个dfs遍历s中所有节点，第二个dfs检测当前s的子节点是否和t是同一棵子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        boolean flag = false;
        //如果两个根节点相等，才进行同个子树比较
        if (s.val == t.val) {
            flag = isSame(s, t);
        }
        return flag || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode root, TreeNode t) {
        if (root == null && t == null) return true;
        if (root == null || t == null) return false;
        //判断值是否相同
        if (root.val != t.val) return false;
        //递归比较左右子树
        return isSame(root.left, t.left) && isSame(root.right, t.right);
    }
}

public class $572_SubtreeofAnotherTree {
}

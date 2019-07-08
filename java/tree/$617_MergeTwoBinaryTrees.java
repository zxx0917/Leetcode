public class $617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //如果两方有一个为null，直接返回另一个
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        //两个节点都不为null
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }
}

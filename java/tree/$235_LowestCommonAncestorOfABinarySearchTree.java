/**
 * 两个节点的最近公共祖先（LCA）有三种情况：(这里假定p.val < q.val)
 * 1.p、q两节点位于LCA的左右子树，即p.val < root.val < q.val
 * 2.p为LCA，q在p的右子树，即p.val == root.val， q.val > root.val
 * 3.q为LCA，p在q的左子树，即q.val == root.val，p.val < root.val
 *
 * 根据BST的性质，从顶向下遍历树，找到第一个p.val <= root.val <= q.val的节点就是LCA
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        //如果p、q两个节点均在root右子树
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //如果两个节点均在root左子树
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //已找到最近公共祖先
        return root;
    }
}

public class $235_LowestCommonAncestorOfABinarySearchTree {
}

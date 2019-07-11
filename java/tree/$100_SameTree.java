/**
 * 使用递归，每个节点逐个比较，递归返回有三个条件：
 * 1.两个节点都为null，返回true
 * 2.两个节点有一个为null，返回false
 * 3.两个节点值不同，返回false
 */
public class $100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //每个节点比较
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

import java.util.Stack;

/**
 * 因为只有两个节点错误，所以只要找出这两个节点然后交换值即可。BST中序遍历是升序结果，
 * 因此进行中序遍历，使用三个指针指示节点，cur为当前节点，pre为当前节点之前的节点，wrongNode为错误节点
 * 当当前节点小于上一个节点时，上一个节点pre就是第一个错误节点，用wrongNode记录，然后继续遍历，找出第二个错误节点，
 * 这里有两种情况：
 * 1.当当前节点大于wrongNode时，它的前节点就是第二个错误节点，如[1,3,2,4]，错误节点分别为3、2
 * 2.遍历结束时仍然没有节点大于wrongNode，则最后一个节点就是错误节点，如[3,1,2]，错误节点为3、2
 */
public class $99_RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur = root, wrongNode = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                //与上一个节点比较，找到错误节点
                if (wrongNode == null && pre != null && cur.val < pre.val) {
                    wrongNode = pre;
                }
                //表示当前节点是否大于wrongNode
                if (wrongNode != null && cur.val > wrongNode.val) {
                    swap(pre, wrongNode);
                    break;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        //如果没有节点大于wrongNode，与最后一个节点交换值
        if (wrongNode != null && wrongNode.val > pre.val) {
            swap(pre, wrongNode);
        }
    }

    private void swap(TreeNode pre, TreeNode wrongNode) {
        int tmp = pre.val;
        pre.val = wrongNode.val;
        wrongNode.val = tmp;
    }
}

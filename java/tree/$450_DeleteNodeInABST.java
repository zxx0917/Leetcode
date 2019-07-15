/**
 * 首先根据BST的性质找到与key相等节点，如果key节点的右子树为null，则直接将左节点放于key节点位置，
 * 如果key节点右子树不为null，则返回右子树的最小节点与key节点处。
 * 如果BST树的左子树为null，则BST树的最小节点就是根节点，如果左子树不为null，在左子树上按照上述规则递归，便可找到最小节点。
 */
public class $450_DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            //如果右子树为null，则返回左子树
            if (root.right == null) {
                return root.left;
            } else {
                //如果右子树不为null，则返回右子树的最小节点
                //node为最小节点，parent为父节点
                TreeNode node = root.right;
                TreeNode parent = root;
                while (node != null && node.left != null) {
                    parent = node;
                    node = node.left;
                }
                //在左子树上删除node节点
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
                //将node节点放在key节点位置上
                node.left = root.left;
                node.right = root.right;
                return node;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}

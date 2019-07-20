import java.util.ArrayList;
import java.util.List;

/**
 * 从根节点开始，子节点的第一个节点放到二叉树的左节点，第二个子节点放在二叉树左子节点的的右节点，第三个子节点放在第二个子节点的右节点，即除了第一个子节点外同一层的其它节点都挂在第一个节点的右子树上
 * 这样就能保证构成的二叉树根节点没有右子树，左子树的根节点+其右子树为同一层的子节点
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        List<Node> children = root.children;
        //第一个子节点存在
        TreeNode cur = null;
        if (!children.isEmpty()) {
            newRoot.left = encode(children.get(0));
            cur = newRoot.left;
        }
        //如果还存在第二个子节点，把子节点挂在第一个子节点的右子树
        for (int i = 1; i < children.size(); i++) {
            cur.right = encode(children.get(i));
            cur = cur.right;
        }
        return newRoot;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node newNode = new Node(root.val, new ArrayList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            newNode.children.add(decode(cur));
            cur = cur.right;
        }
        return newNode;
    }
}

public class $431_EncodeN_aryTreetoBinaryTree {
}

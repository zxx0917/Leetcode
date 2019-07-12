/**
 * 递归，根据完全二叉树的性质，只有最后一层的节点可能不满，所以首先得到左子树和右子树的最大高度，共有以下两种情况：
 * 1.如果左右高度相等，则表示左子树是完整的，使用公式2^height-1来计算节点数，递归求右边子树节点数
 * 2.如果左边子树高度大于右边子树，则表示右子树是完整的，使用公式求出节点数，递归求左边子树节点数
 * 最后返回左右子树元素之和+1即为当前树的总结点数
 */
public class $222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        //1.求出左子树高度
        int leftH = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            leftH++;
            cur = cur.left;
        }

        //2.求出右子树高度
        int rightH = 0;
        cur = root;
        while (cur.right != null) {
            rightH++;
            cur = cur.right;
            //往左边找
            while (cur.left != null) {
                rightH++;
                cur = cur.left;
            }
        }
        int sumLeft = 0, sumRight = 0;
        //3.如果左子树最大高度等于右子树最大高度，表示左子树是满的
        if (leftH == rightH) {
            sumLeft = (int) Math.pow(2, leftH) - 1;
            //递归获取右子树子节点数
            sumRight = countNodes(root.right);
        } else if (leftH > rightH) {
            //右子树是满的，求递归求左子树格式
            sumLeft = countNodes(root.left);
            sumRight = (int) Math.pow(2, rightH) - 1;
        }

        return sumLeft + sumRight + 1;
    }
}

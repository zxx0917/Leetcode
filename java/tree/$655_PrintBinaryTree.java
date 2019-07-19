import java.util.ArrayList;
import java.util.List;

/**
 * 由题意知，当二叉树高度为1时，结果集元素个数为1；高度为2时，结果集元素个数为3，高度为3时，结果集个数为7。所以当高度为depth时，结果集元素个数为[depth-1的结果集元素个数*2+1]
 * 首先求出树的最大高度depth，从而能求出结果集的元素个数width，再构建结果集，使用""填充每个元素，从而构建了一个depth*width的矩形
 * 假设第一行的起始索引位置为0，结束位置为width，我们可以观察到根节点在第一行的最中间位置mid，然后对于其左子树根节点，其插入位置在[0,mid-1]的最中间，其右子树根节点在[mid+1,width]的最中间
 * 所以可以根据以上规律进行二叉树的前序遍历，构建结果集
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        //1.求出root的高度
        int maxDepth = getDepth(root);
        //2.求出输出List的宽度
        int width = 0, count = maxDepth;
        while (count-- > 0) {
            width = width * 2 + 1;
        }
        //对结果集初始化
        List<List<String>> res = new ArrayList<>(maxDepth);
        for (int i = 0; i < maxDepth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            res.add(list);
        }
        //3.前序遍历，首先在结果集中填充左子树，然后填充右子树
        helper(root, 1, 0, width, res);
        return res;
    }

    private void helper(TreeNode root, int depth, int start, int end, List<List<String>> res) {
        if (root == null || start > end) return;
        //获取当前节点需要插入List的位置
        int insert = start + (end - start) / 2;
        //根据当前层数获得对应的List
        //插入根节点，其他位置插入""
        for (int i = start; i <= end; i++) {
            if (i == insert) {
                res.get(depth - 1).set(i, root.val + "");
                break;
            }
        }
        //递归打印左子树
        helper(root.left, depth + 1, start, insert - 1, res);
        helper(root.right, depth + 1, insert + 1, end, res);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}

public class $655_PrintBinaryTree {
}

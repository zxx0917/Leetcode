import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 如果要构成满二叉树则节点个数一定是奇数。当N=1，满二叉树就是它本身；当N=3，满二叉树只有一个，左子树为N=1的满二叉树，右子树为N=3-1-1的满二叉树；
 * 当N=5时，满二叉树有两个，分别为：左子树为N=1的满二叉树，右子树为N=5-1-1，即N=3的满二叉树；分别为：左子树为N=3的满二叉树，右子树为N=5-3-1，即N=1满二叉树
 * 所以依次类推，对于N个节点（奇数），左子树分别为N=1、N=3...N=N-2时的满二叉树，右子树分别为N=N-左子树个数-1的满二叉树，当前节点的子树个数为左子树数*右子树数
 * 构建一个Map，key为节点数，val为对应节点数的满二叉树即可
 */
class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        //避免重复求值
        if (!map.containsKey(N)) {
            List<TreeNode> res = new ArrayList<>();
            if (N == 1) {
                res.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                //左子树
                for (int l = 1; l < N; l += 2) {
                    int r = N - l - 1;
                    for (TreeNode left : allPossibleFBT(l)) {
                        for (TreeNode right : allPossibleFBT(r)) {
                            TreeNode cur = new TreeNode(0);
                            cur.left = left;
                            cur.right = right;
                            res.add(cur);
                        }
                    }
                }
            }
            map.put(N, res);
        }
        return map.get(N);
    }
}

public class $894_AllPossibleFullBinaryTrees {
}

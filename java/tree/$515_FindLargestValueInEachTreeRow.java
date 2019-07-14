import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 方法1：递归。深度优先搜索，遍历时传入List和当前节点对应的高度，高度h的最大值是list.get(h)，每遍历到一个节点就根据所在的高度和保存的最大值比较即可
 * 方法2：迭代：层序遍历，遍历每层节点时获取对应的最大值即可
 */
public class $515_FindLargestValueInEachTreeRow {
    //方法1：递归
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        //首次访问depth层的元素
        if (depth + 1 > res.size()) {
            res.add(root.val);
        }
        //比较当前节点和当前层最大值
        if(root.val > res.get(depth)){
            res.set(depth,root.val);
        }

        //递归
        helper(root.left,res,depth+1);
        helper(root.right,res,depth+1);
    }

    //方法2：层序遍历
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size(),max = Integer.MIN_VALUE;
            while(count-- > 0){
                TreeNode cur = queue.poll();
                //求出每层的最大值
                max = Math.max(cur.val,max);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}

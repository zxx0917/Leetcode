import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 方法1：层序遍历，将每层最后一个元素加入结果集
 * 方法2：递归，先查找右子树，创建一个变量保存当前已访问的最大深度，当访问到新深度时，第一个访问元素就是每层的最右节点
 */
public class $199_BinaryTreeRightSideView {
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count-- > 0){
                TreeNode cur = queue.poll();
                //最后一个元素
                if(count == 0){
                    res.add(cur.val);
                }
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return res;
    }

    //2.递归
    int maxDepth = 0;
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,0,res);
        return res;
    }

    private void helper(TreeNode root, int depth,List<Integer> res) {
        if(root == null) return;
        if(depth+1 > maxDepth){
            res.add(root.val);
            maxDepth = depth+1;
        }
        //先遍历右子树
        helper(root.right,depth+1,res);
        helper(root.left,depth+1,res);
    }
}

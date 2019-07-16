import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层序遍历，每层求出平均值加入结果集即可
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0,count = size;
            while(size-- > 0){
                TreeNode cur = queue.poll();
                //累积当前层的元素和
                sum += cur.val;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            //计算每层平均值
            res.add(sum/count);
        }
        return res;
    }
}

public class $637_AverageofLevelsinBinaryTree {
}

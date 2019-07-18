/**
 *  因为相机可以其父对象、自身及其直接子对象，所以相机放在父节点上是最划算的。从底向上遍历，用1表示节点未监控，用2表示已经安装相机
 */
class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        //为了让根节点在监控到，添加假头
        TreeNode fakeHead = new TreeNode(-1);
        fakeHead.left = root;
        helper(fakeHead);
        return res;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left + right == 0){
            //表示未监控，父节点需要添加相机
            return 1;
        }else if(left == 1 || right == 1){
            //如果子节点有未监控的对象，则此节点添加相机
            res++;
            return 2;
        }else{
            //如果子节点有相机，则返回0
            return 0;
        }
    }
}

public class $968_BinaryTreeCameras {
}

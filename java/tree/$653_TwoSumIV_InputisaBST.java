import java.util.ArrayList;
import java.util.List;

/**
 * BST中序遍历的结果是节点值从小到大排序，将节点值储存于容器中，为了判定容器中是否有两个值之和等于目标值，则设定两个指针，
 * 左右指针分别指向第一个元素和最末元素，分别为容器中的最小值和最大值，求出两个元素之和，如果元素和大于目标值，则需要减小
 * 最大值，即右指针左移，如果元素和小于目标和，则需要增大最小值，即左指针右移，直至两指针相遇。
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) return true;
            else if (sum < k) left++;
            else if (sum > k) right--;
        }
        return false;
    }

    //BST中序遍历，得到的结果是节点值从小到大排列
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

public class $653_TwoSumIV_InputisaBST {

}

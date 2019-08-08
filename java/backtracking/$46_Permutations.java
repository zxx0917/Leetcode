import java.util.ArrayList;
import java.util.List;

/**
 * 因为序列是没有重复数的，所以每次递归从头开始遍历数字，加入结果集，对于每个结果集不能加入之前已经加过的数字，所以创建一个boolean数组，来标识当前数是否被使用
 * 如果没有使用过，则加入结果集，如果使用过，则剪枝。
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        boolean[] flag = new boolean[nums.length];
        helper(nums, new ArrayList<Integer>(), flag);
        return res;
    }

    private void helper(int[] nums, List<Integer> list, boolean[] flag) {
        //如果结果集数等于数组长度，则是一个有效的全排列
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (flag[i]) continue;
            flag[i] = true;
            list.add(nums[i]);
            helper(nums, list, flag);
            //回退
            flag[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
public class $46_Permutations {
}

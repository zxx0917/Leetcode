import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 因为数组可能有重复元素，而重复元素构成的全排列不需要包括在结果集中，所以我们跳过这些重复元素即可。
 * 首先对数组进行从大到小排序，只有这样才能判断下一个元素是否为重复数
 * 构建一个boolean数组来记录当前元素是否使用，如果当前元素未被使用且与前一个元素相同，则它产生的全排列一定是重复的，所以用它来作为剪枝条件
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        helper(nums, flag, new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, boolean[] flag, List<Integer> list) {
        //如果list中的元素个数等于数组长度，表示已经构成一个全排列
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //判断是否是重复元素且前一个元素是否被使用过，如果是重复元素且前前一个数未被使用，则为重复排列
            if (i > 0 && nums[i - 1] == nums[i] && !flag[i - 1]) continue;
            //如果当前元素已经用过，则不再加入结果集
            if (flag[i]) continue;
            flag[i] = true;
            list.add(nums[i]);
            helper(nums, flag, list);
            //回退
            flag[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

public class $47_PermutationsII {
}

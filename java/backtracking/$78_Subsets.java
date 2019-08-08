import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用回溯算法，注意这里获取的是子集，[1,2,3,4]和[2,1,3,4]是一个集合，所以首先对数字进行从小到大排序，
 * 然后对于每个根节点，只能获取大于根节点的值作为子节点，如数组1,2,3,4，对于根元素2，只能获取3,4作为它的子集元素
 * 因为数组不含有重复元素，所以不考虑去重
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            //只能取后面的元素
            helper(nums, i + 1, list);
            //回退
            list.remove(list.size() - 1);
        }
    }
}

public class $78_Subsets {
}

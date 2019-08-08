import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 因为数组中可能有重复数组，所以现将数组从小到大排序，这样重复的数字就排在一起了。
 * 如果当前数字是重复数字并且该数字是作为根节点，则产生的结果会和前一个相同数组的结果重复
 * 所以我们需要构建一个boolean[]来记录数字的使用情况，如果当前数字是重复数字且前一个数字没有使用过，则会产生重复结果，所以这里直接剪枝
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        helper(nums,0,flag,new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, int start, boolean[] flag, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1] && !flag[i-1]) continue;
            list.add(nums[i]);
            flag[i] = true;
            helper(nums,i+1,flag,list);
            flag[i] = false;
            list.remove(list.size()-1);
        }
    }
}

public class $90_SubsetsII {
}

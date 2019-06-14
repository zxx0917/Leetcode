package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序，固定前两个元素，另外两个元素用双指针取值，注意四个值都需要去重
 */
public class $18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            //第一个数去重
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                //第二个数去重
                if (j - i > 1 && nums[j - 1] == nums[j]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    //比较当前和和target的关系
                    if (sum > target) {
                        //缩小大数
                        right--;
                    } else if (sum < target) {
                        //扩大小数
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //第三个数和第四个数去重
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}

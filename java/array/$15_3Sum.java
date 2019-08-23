package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给数组排序，然后从头开始固定一个数字，剩余两个数字使用双指针求出，一个指针指示剩余数据的最小值，一个指示最大值。
 * 根据当前三个数的总和判断两个指针的移动方向
 * 注意如果当前三个元素满足条件，则需要去重。
 */
public class $15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        //1.排序
        Arrays.sort(nums);
        //2.固定一个数，后两个数使用双指针
        for (int i = 0; i < nums.length - 2; i++) {
            //第一个数去重，如果当前数和之前数相同，直接进入下一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                //判断和是否为0
                if (sum == 0) {
                    //符合条件
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    //减少大数
                    right--;
                } else {
                    //增加小数
                    left++;
                }
            }

        }
        return res;
    }
}

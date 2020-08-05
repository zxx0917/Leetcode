package com.summerzhou;

import java.util.Arrays;

/**
 * 这题是15题的类似题，首先对数组进行排序，从小到大排列，然后使用循环每次固定一个数，以左右指针分别指代固定数右边的第一个元素和最后一个元素，求出三数之和。
 * 当和小于target时，移动left指针，使得和增大，如果和大于target，则移动right指针，使得和减小，如果和等于target，则直接返回当前三数和
 * 因为需要找到和target最接近的值，所以我们在每次循环时需要建立一个变量来计算当前三个元素的和与target的差值，从而筛选出最小值。
 *
 */
class Solution {
	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int res = 0, diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			// 第一个元素去重
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int nowDiff = Math.abs(target - nums[left] - nums[right] - nums[i]);
				int sum = nums[left] + nums[right] + nums[i];
				// 筛选当前和是否优于之前的和
				if (diff > nowDiff) {
					diff = nowDiff;
					res = sum;
				}
				if (sum < target) {
					left++;
					// left元素去重
					while (left < right && nums[left - 1] == nums[left])
						left++;
				} else if (sum > target) {
					right--;
					// right元素去重
					while (left < right && nums[right + 1] == nums[right])
						right--;
				} else {
					return target;
				}

			}
		}
		return res;
	}
}

public class $16_3SumClosest {

}

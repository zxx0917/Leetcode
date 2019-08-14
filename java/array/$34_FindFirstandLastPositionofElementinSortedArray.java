/**
 * 因为题目要求时间复杂度为O(logN)，所以需要使用二分查找来获取目标值的上下界
 * 这里推荐大神的题解：https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/
 * 解释得很清楚。
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        //首先找到target的第一个位置
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        //判断数组中是否有target存在，如果没有则直接返回
        if (left == nums.length || nums[left] != target) return new int[]{-1, -1};
        res[0] = left;
        //再一次二分查找，获取target的最后一个位置
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        res[1] = left - 1;
        return res;
    }
}

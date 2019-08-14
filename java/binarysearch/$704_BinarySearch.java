/**
 * 标准二分查找题，时间复杂度O(logN)，练一下基本算法
 * 注意二分查找需要先将数组排序，因为题目给出的数组已经有序了，所以忽略这一步
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

public class $704_BinarySearch {
}

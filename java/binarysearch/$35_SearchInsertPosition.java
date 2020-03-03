/**
 * 简单的二分查找，找到了直接返回索引值，没有找到直接返回二分查找后的left索引，画个图就明白了，不再赘述。
 * 关于二分查找的题解推荐这篇：https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/
 * 写的很好
 */
public class $35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //直接找到目标值，返回
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}

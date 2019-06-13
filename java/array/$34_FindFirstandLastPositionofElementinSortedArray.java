package array;

/**
 * 该题要求时间复杂度为O(logN)，且数据已经排好序，所以优先考虑二分法。
 * 使用二分法找到target在数组中的一个位置，然后前后搜索，直至找到所有target
 */
public class $34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //二分法找到一个target在数组中的位置
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length, index = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (index == -1) return new int[]{-1, -1};
        //从当前元素开始左右搜索相同元素
        int start = index, end = index;
        while (end + 1 < nums.length && nums[end + 1] == target) {
            end++;
        }
        while (start - 1 >= 0 && nums[start - 1] == target) {
            start--;
        }

        return new int[]{start, end};
    }
}

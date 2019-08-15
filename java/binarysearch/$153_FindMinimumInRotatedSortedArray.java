/**
 * 有序的数组被翻转一次后数组会分为两段，两段都是有序的，如[4,5,6,7,0,1,2]，而需要找的最小元素是第二段有序数组的第一个元素
 * 所以我们可以采用二分法，如果中间元素大于最右边元素，表示中间元素位于第一段数组中，最小值在它的右边，所以增加Left，left=mid+1
 * 如果中间元素小于最右边元素，表示中间元素已经在第二段数组中了，最小元素可能就是中间元素，或者在它的左边，所以减小right，right=mid，如[5,6,0,1,2,3,4]
 * 最后遍历完成后返回nums[left]即可
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }
}

public class $153_FindMinimumInRotatedSortedArray {
}

package array;

/**
 * 找出分界点，然后两个升序数组第一个元素比较就能获得结果。
 * 这里需要注意去重，因为数组可能存在重复元素，所以当分界点位于重复元素之间时需要将右边的重复元素除去
 */
public class $154_FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //1.去重
        int left = 0, right = n - 1;
        while (left < right && nums[left] == nums[right]) {
            right--;
        }

        //2.找到分界点
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left]; 
    }
}

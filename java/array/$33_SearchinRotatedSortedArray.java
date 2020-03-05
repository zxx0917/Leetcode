package array;

/**
 * 由提议可知数组中存在分界点，分界点前后的数组都是升序的
 * 1.先找出分界点使用二分法，如果中间元素的大于最右边元素，表示分界点一定在右边数组，left=mid+1，
 * 如果中间元素小于最右边元素，则表示右边数组是升序的，分界点在中间元素的左边或者就是中间元素，即right=mid
 * 2.然后比较target与最右边元素的大小关系，来判定target位于左右哪个数组，根据结果固定数组分界点，然后进行二分法即可
 */
public class $33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }

        //判断Target在左数组还是右数组
        //判断Target在左数组还是右数组
        if (target > nums[nums.length - 1]) {
            return binarySearch(nums, 0, left-1, target);
        } else {
            return binarySearch(nums, left, nums.length - 1, target);
        }

    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}

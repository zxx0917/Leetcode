package array;

/*
 *首先找出旋转数组的分界点，然后根据target在前后哪个数组进行二分查找
 *只是要注意该数组有重复元素，分界点可能位于重复元素中，使得分界点前后两个数组不是升序的，所以需要先除去后端可能存在的重复元
 *如[3,3,3,0,1,2,3,3]的分界点在3中，所以需要将右边的重复3除去，得到方便计算，变为【3,3,3,0,1,2】
 */
public class $81_SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        //1.通过二分法首先找到分界点
        //1.1首先排除分界点处于重复元素之中
        int left = 0, right = nums.length - 1;
        while (right > left && nums[left] == nums[right]) {
            right--;
        }
        int trueRight = right;
        //1.2 找到分界点
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //判断target在分界点左边还是右边
        if (target > nums[trueRight]) {
            return binarySearch(nums, 0, left - 1, target) != -1;
        } else {
            return binarySearch(nums, left, trueRight + 1, target) != -1;
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

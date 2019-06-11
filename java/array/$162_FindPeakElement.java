package array;

/**
 * 采用二分法，如果nums[mid] < nums[mid+1]，则峰值一定在[mid+1,nums.length]中，
 * 因为如果nums[mid]<nums[mid+1]，则mid+2元素有两种情况:
 * 一种是nums[mid]<nums[mid+1]>nums[mid+2]，则mid+1为峰值;
 * 另一种是nums[mid]<nums[mid+1]<nums[mid+2]，则继续向右推，如果一直到边界都是上升的，则最后一个元素为峰值，因为nums[nums.length]=-∞；
 * 如果nums[mid] > nums[mid+1]，则峰值在[0,mid].
 */
class $162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        //O(logN)的算法考虑二分法
        if(nums.length <= 1) return 0;

        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] < nums[mid+1]){
                //如果nums[mid]<nums[mid+1]，则[mid+1,nums.length]一定有峰值
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}

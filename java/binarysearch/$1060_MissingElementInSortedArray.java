/**
 * 因为数组本来是有序的，且每个数字不同，所以可以使用二分法来获取结果，注意这里二分的不是数组索引，而是数组元素
 * 举例：对于数组[4,7,9,10]，left=4，right=10，其中间数为mid=7，对于没有缺失元素的数组，小于等于mid的元素应该有4个，即[4,5,6,7]，
 * 而在本数组中，小于等于mid的元素为2个，即[4,7]，表示左半边缺失了2个元素，因为k=3，所以缺失的元素一定在右半边，即(7,10]之间
 * 综上，我们可以统计出数组中小于等于mid的元素个数count，而对于不缺失元素的数组，小于等于mid的元素个数应该为[mid-最左边元素+1]，
 * 如果[mid-最左边元素+1]-count < k，则表示第k个缺失的数在右半边，left = mid+1，
 * 如果[mid-最左边元素+1]-count > k，则表示第k个缺失的数在左半边，right = mid;
 * 最后循环结束时left就是第k个缺失数组
 * 这里需要注意right的取值，因为我们是对数组元素进行二分查找，而第k个缺失的元素可能不在nums中，如[1,2,4]，k=3，这里的结果应该是6
 * 所以right=nums数组的最后一个元素+k，这样才能保证找到k个缺失的元素
 */
class Solution {
    public int missingElement(int[] nums, int k) {
        int left = nums[0], right = nums[nums.length - 1] + k, min = nums[0];
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
                else break;
            }
            int noMissingCount = mid - min + 1;
            if (noMissingCount - count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}


public class $1060_MissingElementInSortedArray {
}

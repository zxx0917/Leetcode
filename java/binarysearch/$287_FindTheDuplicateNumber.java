/**
 * 这道题目可以排序后遍历数组，找到第一个和后一个元素相同的元素，即为结果时间复杂度为O(NlogN)，空间复杂度为O(1)
 * 还可以使用Set，遍历数组，如果有元素已经存在于Set中，直接返回结果，时间复杂度为O(N)，空间复杂度为O(N)
 * 这两种方法都不符合题目要求，使用二分法是最好的。
 * <p>
 * 这里不二分数组的索引，而是二分数组的值，比如对于数组[1,2,3,4,5]，中位数是3，因为数组中没有重复的值，所以左右两边的元素个数相同
 * 对于有重复元素的数组，如[1,2,2,2,5,6]，中位数是3，小于3的元素有4个，大于3的元素有2个，所以重复的元素在[1,3]之间
 * 综上，对于一个数组的中位数mid，如果数组中小于等于的mid的个数>mid，则表示重复元素在[left,mid]中，right = mid
 * 否则重复元素在(mid,right]中，left = mid + 1
 * 这种方法的时间复杂度为O(NlogN)，空间复杂度为O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length;
        while (left < right) {
            int mid = (right + left) >> 1;
            //计数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

public class $287_FindTheDuplicateNumber {
}

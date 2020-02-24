/**
 * 167题是第1题两数之和的变体，可以使用第一题的Map法解题，时间复杂度和空间复杂度都是O(n)。
 * 但是这道题给出了一个新条件：数组中的元素都是升序的，我们建立两个指针left/right，分别表示数组中第一个元素的索引和最后一个元素的索引。
 * nums[left]指代数组中最小的值，nums[right]指代数组中最大的值，将这两个值相加，与target比较，如果小于target，则需要增加较小的数，
 * 即让left右移一位，如果大于target，则需要减小最大的数，将right左移一位，直到两个指针相遇或者两者指代的元素和等于target。
 */
public class $167_2SumII {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return new int[]{};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }
}

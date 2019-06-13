package array;

/**
 * 这道题为滑动窗口题，创建两个变量分别指代窗口左边或右边，
 * 当窗口内元素小于s时，窗口右指针右移，扩大窗口面积，
 * 如果窗口内元素大于等于s时，记录当前窗口长度，并将最左边的元素排出窗口，实现窗口滑动，直至窗口元素小于s
 * 最后最小的窗口长度即为结果
 */
public class $209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0,right = 0,res = nums.length+1,sum = 0;
        while(right < nums.length){
            if(sum < s){
                sum += nums[right];
                right++;
            }
            while(sum >= s){
                res = Math.min(res,right-left);
                sum -= nums[left];
                left++;
            }
        }
        return res == nums.length+1?0:res;
    }
}

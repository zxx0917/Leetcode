package array;

/**
 * 因为题中可以跳[1,当前元素]步，所以设定两个指针，一个指针从后往前遍历元素，另一个指针end指代最后一个元素的位置
 * 当当前元素可以跳到最后一个元素时，截断数组，将end移动到当前元素，如果最后end指针处于第一个元素处，则表示可以到达
 */
public class $55_JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        int end = nums.length-1,i = nums.length-2;
        while(i >= 0){
            if(nums[i] >= end-i){
                end = i;
            }
            i--;
        }

        return end == 0;
    }
}

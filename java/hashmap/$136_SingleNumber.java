package array;

/**
 * 因为a^a^b = b，a ^ a = 0, 0 ^ b = b，所以根据题意将每个元素异或起来就能得到最终结果。
 */
public class $136_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1;i < nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }
}

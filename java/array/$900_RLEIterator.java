package array;

import java.util.Arrays;

/**
 * 在原数组上进行值的修改
 */
class RLEIterator{
    //储存数组A
    int[] nums;
    int i = 0;
    public RLEIterator(int[] A) {
        nums = Arrays.copyOf(A,A.length);
    }

    public int next(int n) {
        for(;i < nums.length;i+=2){
            //判断当前元素是否能取尽
            int remain = nums[i]-n;
            if(remain >= 0){
                nums[i] -= n;
                return nums[i+1];
            }else{
                //未取尽，取下一个
                n -= nums[i];
            }
        }
        return -1;
    }
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */

public class $900_RLEIterator {

}

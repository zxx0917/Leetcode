/**
 * 该题目的题意是找出num平方根的整数部分，如8，平方根的整数部分为2。
 * 我们可知平方根的范围在[1,n/2]之间，因为是找到其中一个数且区间已经排好序，所以采用二分法，找到i*i为小于num的最大值即可。
 * 如对于8，在[1,2,3,4]中，2*2为小于8的最大值，所以返回2
 * 当找到i*i==num时，直接返回i，如果i*i > num，减小right，如果i*i < num，增大left
 * 注意将变量声明为Long型，避免相乘时超限
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long left = 1, right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else if (mid * mid > x) {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }
}

public class $69_Sqrtx {
}

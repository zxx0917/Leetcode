/**
 * 被除数÷除数=商...余数
 * 因为不能使用乘、除、模，所以首先考虑的使用减法，被除数可以减去n次除数就是商，但是减法的效率太低。
 * 这里使用位运算，范围为[0,31]，从31开始，遇到第一个使得被除数/2^i>=除数的数，记录2^i，然后余下的数继续求商，
 * 最后可以得到可以被res个除数整除
 */
class Solution {
    public int divide(int dividend, int divisor) {
        //如果被除数为0
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        //使用异或判断结果的正负号
        boolean negative = (dividend ^ divisor) < 0;
        int res = 0;
        //都转换为正数
        long div = Math.abs((long) dividend), divs = Math.abs((long) divisor);
        for (int i = 31; i >= 0; i--) {
            if ((div >> i) >= divs) {
                //结果加上2^i
                res += 1 << i;
                //被除数减去divisor*2^i
                div -= divs << i;
            }
        }
        return negative ? -res : res;
    }
}

public class $29_DivideTwoIntegers {
}

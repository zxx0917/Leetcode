/**
 * 首先：被除数÷除数=商...余数 num >> i，为num除以2的i次方，num << i，为num乘以2的i次方
 * 因为题目不能使用乘、除、加，首先想到的是使用减法，被除数能减去多少次除数就是结果，但是减法效率太低。
 * 这里考虑使用位运算，num>>i，表示num/2^i，i的范围是[0,31]，我们从31开始，求出第一个使得divident>>i>=divisor的数
 * 如100/3，100/32=3，正好大于等于3，而余数为100-32*3=4，4/1 >= 3，所以一共减去了33个3，商为33。
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

/**
 * 对于以下数字1010，n-1为1001，n&(n-1)=1000，而1000的n-1为0111，1000&0111=0，总共循环两次，正好是1的个数
 * 不用纠结，直接记住就行
 */
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        int count = 1;
        while ((n & (n - 1)) != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}

public class $191_NumberOf1Bits {
}

/**
 * 使用位运算，从右到左取原输入数的每一位，然后在向左位移到反转指定位置，最后将结果结合一起
 * 掌握获取指定位置的二进制数，如想获取第4个二进制数，则将数字右移3为，与1进行&操作，就可以获得当前位的二进制数
 * 即获得第n个二进制数，将数字右移n-1位，与1进行&操作
 */
class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //输入的二进制数从右到左取出
            int tmp = n >> i;
            //取出当前二进制数
            tmp &= 1;
            //左移到翻转位置
            tmp = tmp << (31 - i);
            //组合结果
            res |= tmp;
        }
        return res;
    }
}

public class $190_ReverseBits {
}

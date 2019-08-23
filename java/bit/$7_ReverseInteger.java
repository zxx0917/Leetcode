
/**
 * 逐步求出x从右到左的每一位，然后将每一位放到翻转后的新位置，使用num=num*10+bit来计算，这里的难点就是判断数字是否溢出，
 * 输入x是正数，则有两种情况会溢出：1.res > Integer.MAX_VALUE/10；2.res == Integer.MAX_VALUE/10 && tmp > Integer.MAX_VALUE % 10;
 * 输入x是负数，则有两种情况会溢出：1.res < Integer.MIN_VALUE/10；2.res == Integer.MIN_VALUE/10 && tmp < Integer.MIN_VALUE % 10;
 */
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //从右至左求出每位的数字
            int tmp = x % 10;
            x = x / 10;
            //输入x是正数，则有两种情况会溢出：1.res > Integer.MAX_VALUE/10；2.res == Integer.MAX_VALUE/10 && tmp > Integer.MAX_VALUE % 10;
            //输入x是负数，则有两种情况会溢出：1.res < Integer.MIN_VALUE/10；2.res == Integer.MIN_VALUE/10 && tmp < Integer.MIN_VALUE % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10))
                return 0;
            else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < Integer.MIN_VALUE % 10))
                return 0;
            //将求出的数字放到新位置
            res = res * 10 + tmp;
        }
        return res;
    }
}

public class $7_ReverseInteger {
}

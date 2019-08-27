/**
 * 因为只有三种面额的钱：5/10/20，所以需要找零的只有两种情况：10和20，10元找零5元，20元找零15元，而15元有两种情况：1个10元+1个5元、3个5元
 * 所以创建两个变量保存手里有5元和10元的个数，如果不能满足上述找零条件则返回false
 * 注意这里15元找零优先选择1个10元+1个5元，因为5元更精贵，剩余的5元零钞越多，后面越方便找零
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            int res = bill - 5;
            if (res == 5) {
                //没有5元零钞
                if (five == 0) return false;
                five--;
                ten++;
            } else if (res == 15) {
                //优先选择1个10元+1个5元
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    //两种找零都不满足
                    return false;
                }
            } else {
                five++;
            }
        }
        return true;
    }
}


public class $860_LemonadeChange {
}

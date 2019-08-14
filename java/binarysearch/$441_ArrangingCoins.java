/**
 * 第一行1个
 * 第二行2个
 * 第三行3个
 * 第n行n个，
 * 我们可以逐行递减n，直到n小于0。分为两种情况，如果最后n正好为0，表示n可以将第i层全部填满，返回i，如果n为负数，则表示n不能将i层填满，返回i-1
 */
class Solution {
    public int arrangeCoins(int n) {
        if (n == 1) return 1;
        int i = 0;
        while (n > 0) {
            i++;
            n -= i;
        }
        return n == 0 ? i : i - 1;
    }
}

public class $441_ArrangingCoins {
}

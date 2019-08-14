/**
 * 完全平方数是可以通过两个相同的数相乘得到，如16=4*4,16就是完全平方数
 * 因为题目不能使用内置函数，所以我们想别的方法。
 * 可知一个数的因子的范围是[1,n/2]，所以我们可以在这个范围内找到是否有一个数，使得num/i = i
 * 因为数字范围是升序，而且一个完全平方数的因子往往是落在[1,n/2]中间，如16的因子为4，在[1,8]之间，所以我们采用二分法找到对应的因子
 * 如果找到，直接返回true
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //注意要取double，如果是int会抹掉后面的小数点，出错
            double i = (double) num / mid;
            if (i == mid) {
                return true;
            } else if (i < mid) {
                //求出的除数小于mid，说明mid太大，减小right
                right = mid - 1;
            } else if (i > mid) {
                //求出的除数大于mid，说明mid太小，增大left
                left = mid + 1;
            }
        }
        return false;
    }
}

public class $367_ValidPerfectSquare {
}

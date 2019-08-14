/**
 * 这道题意是我们可以调用一个方法guess(int num)，然后系统会返回给我们一个值，代表我们猜的这个数比目标数小、大、还是相等。
 * 我们需要编写一个方法，知道猜出系统给出的值。
 * 当前我们已经知道数字的范围在[1,n]，所以使用二分查找法，首先获取最中间的值mid，调用guess(mid)，根据返回值来缩小搜索范围，直到找到目标数
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = guess(mid);
            //如果猜中，直接返回
            if (tmp == 0) return mid;
            else if (tmp == -1)
                //目标数更小，减小right
                right = mid - 1;
            else if (tmp == 1)
                //目标数更大，增大left
                left = mid + 1;
        }
        return -1;
    }
}

public class $374_GuessNumberHigherOrLower {
}

/**
 * 1~10的好数为：2/5/6/9，旋转后仍然是同一个数的为：1/8/0
 * 可知只要一个数中全是好数，则该数一定是好数，如25
 * 如果一个数中全是旋转同数+好数，则一定是好数，如121
 * 如果一个数全是旋转同数，则一定不是好数，如110
 */
class Solution {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            String num = i + "";
            if (isGoodNum(num.toCharArray()))
                res++;
        }
        return res;
    }

    //判断当前数是否是好数
    private boolean isGoodNum(char[] chars) {
        //判断当前数是否全是旋转同数
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '3' || chars[i] == '4' || chars[i] == '7') return false;
            if (chars[i] == '2' || chars[i] == '5' || chars[i] == '6' || chars[i] == '9') flag = false;
        }
        //如果是全是旋转同数，返回false
        if (flag) return false;
        return true;
    }
}

public class $788_RotatedDigits {
}

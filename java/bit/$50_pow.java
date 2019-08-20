/**
 * 使用递归，例如3^10 = 3^5 * 3 ^ 5；所以，对于x^n，如果n为偶数，则x^n = x ^(n/2) * x ^(n/2)；如果n为奇数，则x^n = x ^(n/2) * x ^(n/2) * x
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == -1) {
            //如果n为偶数，返回1
            if ((n & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (x == 1) return 1;
        if (n == Integer.MIN_VALUE) return 0;
        //递归，如果n为负数，需要处理
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return getPow(x,n);
    }

    private double getPow(double x, int n) {
        if (n == 0) return 1;
        //如果n为偶数
        if ((n & 1) == 0) {
            double part = getPow(x, n / 2);
            return part * part;
        } else {
            double part = getPow(x, n / 2);
            return part * part * x;
        }
    }
}

public class $50_pow {
}

/**
 * 使用递归，例如3^10 = 3^5 * 3 ^ 5；所以，对于x^n，如果n为偶数，则x^n = x ^(n/2) * x ^(n/2)；如果n为奇数，则x^n = x ^(n/2) * x ^(n/2) * x
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (x == -1) {
            //n是偶数
            if ((n & 1) == 0) return 1;
            else return -1;
        }
        //判断结果是否需要取倒数，如果需要，则直接先求倒数，然后再递归计算
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return getPow(x, n);
    }

    //递归求pow
    private double getPow(double x, int n) {
        if (n == 0) return 1;
        double part = getPow(x, n / 2);
        //1.如果是偶数
        if ((n & 1) == 0) {
            return part * part;
        } else {
            //如果是奇数
            return part * part * x;
        }
    }
}

public class $50_pow {
}

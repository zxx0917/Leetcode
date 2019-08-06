/**
 * 首先，如果有x能够同时组成str1和str2，则str1+str2 == str2+str1，否则直接返回false
 * 在有解的情况下，两个字符串的最大公因子的长度一定是两个字符串长度的最大公约数，使用辗转相除法
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int a = Math.max(str1.length(), str2.length());
        int b = Math.min(str1.length(), str2.length());
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return str1.substring(0, a);
    }
}

public class $1071_GreatestCommonDivisorOfStrings {
}

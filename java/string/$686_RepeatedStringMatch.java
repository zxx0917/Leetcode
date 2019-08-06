/**
 * 如果A的长度大于B，则有两种情况：
 * 1.B是A的子字符串，不需要重复叠加，如A="abcd"，B="bc"
 * 2.B不是A的子字符串，如果两个A叠加，可以得到B，如A="aab",B="ba"
 * 如果A的长度小于B，则A重叠的次数不超过B.length()/A.length()+2次，因为B.length()/A.length()是B串的中间A需要重复的次数，
 * 然后再在首尾加上A串，就是它的最多重叠次数
 */
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n = B.length() / A.length(), count = n;
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            sb.append(A);
        }

        while (n <= B.length() / A.length() + 2) {
            if (isSubstring(sb.toString(), B)) return n;
            sb.append(A);
            n++;
        }
        return -1;
    }

    //判断StrB是否是StrA的子字符串
    private boolean isSubstring(String strA, String strB) {
        for (int i = 0; i <= strA.length() - strB.length(); i++) {
            //如果当前字符和strB的首字符相同
            boolean flag = true;
            if (strA.charAt(i) == strB.charAt(0)) {
                for (int j = 1; j < strB.length(); j++) {
                    if (strA.charAt(i + j) != strB.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}

public class $686_RepeatedStringMatch {
}

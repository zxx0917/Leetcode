/**
 * 根据题意可知将A翻转两个字符就能得到B，分情况讨论：
 * 1.两者长度必须相同
 * 2.两者不能全为空
 * 3.两者只能有两个字符不相等
 * 4.假设这两个不相等字符的索引为i和j，则在位置i时，A的字符等于B在j的字符，在位置j时，A的字符等于B在i的字符，否则返回false
 * 5.如果两者是同个字符串，则字符串中至少要包括两个相同字符
 */
class Solution {
    public boolean buddyStrings(String A, String B) {
        //如果两者长度不同，返回false
        if (A.length() != B.length()) return false;
        //全部为空，返回false
        if (A.isEmpty() && B.isEmpty()) return false;
        int j = -1, k = -1;//记录两者不相等字符的位置
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                //记录第一个不相等的位置
                if (j == -1) j = i;
                else if (k == -1) {
                    //到达第二个不相等的位置，判断A、B对应字符是否相同
                    k = i;
                    if (A.charAt(j) != B.charAt(k) || A.charAt(k) != B.charAt(j)) return false;
                } else {
                    //如果出现第三个不相同的位置，直接返回false
                    return false;
                }
            }
        }
        //如果只有一处不同，则返回false
        if (j != -1 && k == -1) return false;
        //如果两者相同，则判断同一字符串中是否有两个相等元素，如果有则返回true
        if (j == -1 && k == -1) return hasSameChar(A);
        return true;
    }

    private boolean hasSameChar(String str) {
        int[] dict = new int[26];
        for (char c : str.toCharArray()) {
            if (dict[c - 'a'] >= 1) return true;
            dict[c - 'a']++;
        }
        return false;
    }
}

public class $859_BuddyStrings {
}

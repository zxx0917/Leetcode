/**
 * 使用双指针，分别从字符串头和尾开始向中间遍历，如果两个字符相等，则表示是回文串的一部分，继续遍历；
 * 如果两个字符不相等，则将左右指针分别内移一位，判断剩余的部分是否是回文串
 */
class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0, right = s.length() - 1, count = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrom(s, left + 1, right) || isPalindrom(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isPalindrom(String s, int left, int right) {
        if (left > right) return true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

public class $680_ValidPalindromeII {
}

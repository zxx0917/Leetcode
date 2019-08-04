/**
 * 首先将字符串全部转为小写，然后使用双指针，找到第一个和最后一个数字或字母，比较两者是否相等，然后再找到第二个和倒数第二个比较，以此类推
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //找到左边的数字或字母
            while (left < right) {
                char c = s.charAt(left);
                if ((c < '0' || c > '9') && (c < 'a' || c > 'z')) left++;
                else break;
            }
            //找到右边的数字或字母
            while (left < right) {
                char c = s.charAt(right);
                if ((c < '0' || c > '9') && (c < 'a' || c > 'z')) right--;
                else break;
            }
            //比较是否相等
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}

public class $125_ValidPalindrome {
}

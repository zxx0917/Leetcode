/**
 * 直接将数字变为字符串，然后使用双指针逐个比较左右两侧的字符，如果不同返回false
 */
class Solution {
    public boolean isPalindrome(int x) {
        //变为char数组
        if(x == 0) return true;
        String str = x + "";
        char[] chars = str.toCharArray();
        int left = 0,right = chars.length-1;
        while(left < right){
            if(chars[left++] != chars[right--]) return false;
        }
        return true;
    }
}

public class $9_PalindromeNumber {
}

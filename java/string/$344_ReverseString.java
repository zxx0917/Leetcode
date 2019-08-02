/**
 * 使用异或进行字符交换，b = a ^ b;a = a ^ b;b = a ^ b
 * 因为相同数异或等于0，而和0异或结果不变，所以可以用来进行交换
 */
class Solution {
    public void reverseString(char[] s) {
        if (s.length == 0) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[right] = (char) (s[left] ^ s[right]);
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[left] ^ s[right]);
            left++;
            right--;
        }
    }
}

public class $344_ReverseString {
}

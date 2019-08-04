
/**
 * 题意是输入字符串不只是有英文字母，对于第一个英文字母和最后一个英文字母，翻转，第二个英文字母和倒数第二个字母翻转，以此类推
 * 这里使用双指针法，一个指向头、一个指向尾，遇到了英文字母就翻转
 */
class Solution {
    public String reverseOnlyLetters(String S) {
        if (S.length() == 0) return S;
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            //找到左边的字母
            while (left < right) {
                if (chars[left] < 'A' || (chars[left] > 'Z' && chars[left] < 'a') || chars[left] > 'z') left++;
                else break;
            }
            
            //找到右边的字母
            while (left < right) {
                if (left < right && chars[right] < 'A' || (chars[right] > 'Z' && chars[right] < 'a') || chars[right] > 'z')
                    right--;
                else break;
            }

            //交换位置
            reverse(chars, left++, right--);
        }
        return new String(chars);
    }

    private void reverse(char[] arrs, int lo, int hi) {
        if (lo >= hi) return;
        char tmp = arrs[lo];
        arrs[lo] = arrs[hi];
        arrs[hi] = tmp;
    }
}

public class $917_ReverseOnlyLetters {
}

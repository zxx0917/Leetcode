import java.util.Arrays;
import java.util.List;

/**
 * 题目中所谓的翻转是否分别从字符串的头、尾开始找元音，从头开始的第一个元音和倒数第一个元音交换位置，从头开始的第二个元音和倒数第二个元音交换位置
 * 如Hello -> Holle 即第一个元音和最后一个元音交换
 * 所以可以采用双指针法，进行上述交换
 * 注意，题目还给出了大写字符，所以也需要将大写元音放入字典表
 */
class Solution {
    public String reverseVowels(String s) {
        if (s.length() == 0) return "";
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            //如果左指针不为元音，继续寻找
            while (left < right && !list.contains(s.charAt(left))) left++;
            //如果右指针不为元音，继续寻找
            while (left < right && !list.contains(s.charAt(right))) right--;
            //如果左右指针都为元音，交换
            if (left < right && list.contains(s.charAt(left)) && list.contains(s.charAt(right))) {
                reverse(chars, left++, right--);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] arr, int lo, int hi) {
        if (lo > hi) return;
        arr[hi] = (char) (arr[lo] ^ arr[hi]);
        arr[lo] = (char) (arr[lo] ^ arr[hi]);
        arr[hi] = (char) (arr[lo] ^ arr[hi]);
    }
}

public class $345_ReverseVowelsOfAString {
}

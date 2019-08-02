/**
 * 使用空格将字符串分割，按顺序翻转每个单词，然后拼接即可，注意每个单词后要加上空格
 */
class Solution {
    public String reverseWords(String s) {
        if (s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        for (String str : s.split(" ")) {
            sb.append(reverse(str)).append(" ");
        }
        //把最后一个空格去掉
        return sb.substring(0, sb.length() - 1);
    }

    //翻转字符串
    private String reverse(String str) {
        char[] s = str.toCharArray();
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[right] = (char) (s[left] ^ s[right]);
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[left] ^ s[right]);
            left++;
            right--;
        }
        return new String(s);
    }
}

public class $557_ReverseWordsInAStringIII {
}

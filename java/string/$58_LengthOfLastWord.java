/**
 * 首先略去结尾的空格，再从字符串尾部开始计数，遇到第一个空格就返回计数器，即为最后一个单词长度
 * 这种基础算法题最好不要用现成的API
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        //除去尾部的空格
        int end = s.length() - 1;
        while (end >= 0) {
            if (s.charAt(end) != ' ') break;
            end--;
        }
        s = s.substring(0, end + 1);

        int res = 0, cur = s.length() - 1;
        while (cur >= 0) {
            if (s.charAt(cur--) == ' ') break;
            res++;
        }
        return res;
    }
}

public class $58_LengthOfLastWord {
}

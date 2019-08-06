/**
 * 这里的单词指的是连续的不是空格的字符。所以"a,"和","都是单词
 * 遍历整个字符串，对于非空的字符，如果下一个字符是空格或到达字符串末尾，则算是一个单词，如果下一个字符不为空，继续遍历
 */
class Solution {
    public int countSegments(String s) {
        if (s.length() == 0) return 0;
        int res = 0, i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != ' ') {
                //遍历到空格
                while (i < s.length() - 1) {
                    if (s.charAt(i + 1) == ' ') {
                        res++;
                        break;
                    }
                    i++;
                }
            }
            i++;
        }
        //如果最后一个字符是非空，则需要将最后一个单词加入res
        if (s.charAt(s.length() - 1) != ' ') res++;
        return res;
    }
}

public class $434_NumberOfSegmentsInAString {
}

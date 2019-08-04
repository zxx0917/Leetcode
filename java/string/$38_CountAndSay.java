/**
 * 这道题就是当前数报前一个数的序列，如1的序列为1，则n=2时报1的序列，就是1个1，结果为11，n=3时报2的序列，就是2个1，结果为21，依次
 * 其实就是求出前一个字符串中每个字符的个数，然后按顺序输出即可，如n=5为111221，则n=6时，n=5有3个1，2个2，1个1，则结果为312211
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 0) return "";
        int num = 1;
        String s = "1";
        while (num++ < n) {
            int  i = 0;
            StringBuilder sb = new StringBuilder();
            //对当前字符串计数
            while (i < s.length()) {
                int count = 1;
                while (i < s.length() - 1) {
                    if (s.charAt(i + 1) == s.charAt(i)) {
                        count++;
                        i++;
                    }
                    else break;
                }
                sb.append(count).append(s.charAt(i++));
            }
            //进入下一次循环
            s = sb.toString();
        }
        return s;
    }
}

public class $38_CountAndSay {
}

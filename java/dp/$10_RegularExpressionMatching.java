import java.util.EmptyStackException;

class Solution {
    //匹配是指p算上正则表达式后等于s，对于.，就是万能符，不用考虑，对于*，需要考虑前面一个字符
    //考虑使用递归，每次比较第一个字符，对于*，如果第二个字符为*，则分为两种情况：
    // 1.如果p[0]=s[0]，则s的指针往右移一位，p的位置不变，比较后续的s字符是否还需要此*
    // 2.如果p[0]!=s[0]，则不需要*前的字符，将p的指针后移两位
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean flag = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        //判断是否有*
        if (p.length() >= 2 && p.charAt(1) == '*') {
            if (flag) return isMatch(s.substring(1), p);
            else return isMatch(s, p.substring(2));
        } else {
            return flag && isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
        }
    }
}

public class $10_RegularExpressionMatching {
}

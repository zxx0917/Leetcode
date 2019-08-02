/**
 * 使用StringBuilder来建立目标字符串，遍历原字符串，如果不是元音，则加入结果
 */
class Solution {
    public String removeVowels(String S) {
        if (S.isEmpty()) return S;
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (cur < S.length()) {
            char c = S.charAt(cur++);
            if (c != 'a' && c != 'e' && c != 'o' && c != 'i' && c != 'u') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

public class $1119_RemoveVowelsfromAString {
}

/**
 * 使用双指针，一根指向name，一根指向typed，总共有如下几种情况：
 * 1.当name的字符与typed的当前字符相等，且name的下一个字符也与typed的下个字符相等，则两个指针一起右移一位，如name="aab"，typed="aab"
 * 2.当name的字符等于typed的字符且typed的下个字符是长按出来的，则name指针右移一位，typed的指针右移到第一个与当前字符不同的位置，如name="ab",typed="aaab"
 * 3.当name的字符不等于typed的字符时，返回false
 * 4.如果两个指针不是同时到达字符串尾，则返回false，如name="ppr"，typed="pp"
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        //定义双指针
        int curName = 0, curTyped = 0;
        while (curName < name.length() && curTyped < typed.length()) {
            if (name.charAt(curName) == typed.charAt(curTyped)) {
                //如果两者相同，且typed的下个字符是长按出来的
                while (curTyped < typed.length() - 1 && curName < name.length() - 1) {
                    if (typed.charAt(curTyped + 1) == typed.charAt(curTyped)
                            && name.charAt(curName + 1) != name.charAt(curName)) {
                        curTyped++;
                    } else break;
                }
                curTyped++;
                curName++;
            } else {
                return false;
            }

        }
        return curName == name.length();
    }
}

public class $925_LongPressedName {
}

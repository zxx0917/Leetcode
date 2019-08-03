/**
 * 判断第一个字符与第二个是否都大写：
 * 1.如果都是大写，则判断后面所有的字符是否全为大写
 * 2.如果都不是大写，或第一个字符是大写、第二个字符为小写，则判断后面所有的字符是否全为小写
 * 3.其他情况返回false
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0 || word.length() == 1) return true;
        char firstC = word.charAt(0), secondC = word.charAt(1);
        //都是大写
        if (firstC >= 'A' && firstC <= 'Z' && secondC >= 'A' && secondC <= 'Z') {
            for (int i = 2; i < word.length(); i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') return false;
            }
            return true;
        }
        //第一个字符是大写，第二个是小写或者两个都是小写
        if ((firstC >= 'a' && firstC <= 'z' && secondC >= 'a' && secondC <= 'z') || (firstC >= 'A' && firstC <= 'Z' && secondC >= 'a' && secondC <= 'z')) {
            //判断后面是否都是小写
            for (int i = 2; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') return false;
            }
            return true;
        }
        return false;
    }
}

public class $520_DetectCapital {
}

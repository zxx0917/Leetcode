import java.util.ArrayList;
import java.util.List;

/**
 * 遍历一遍字符串，如果遇到了两个连续的++，转换为--，加入结果集后再还原，遍历到结尾即可
 */
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) return res;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            //判断是否有连续两个+
            if (chars[i] == '+' && chars[i + 1] == '+') {
                //转换
                chars[i] = '-';
                chars[i+1] = '-';
                //加入结果集
                res.add(new String(chars));
                //还原
                chars[i] = '+';
                chars[i+1] = '+';
            }

        }
        return res;
    }
}

public class $293_FilpGame {
}

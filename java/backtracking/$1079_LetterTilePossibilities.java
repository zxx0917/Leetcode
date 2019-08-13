import java.util.Arrays;

/**
 * 该题题的题意是求出输入字符串中所有可能的子字符串组合个数，注意要排除重复的组合。
 * 对于AAB，如果取字符B为第一个字符，则后续的排列为BA、BAA，表示每次递归需要从0开始。
 * 这里采用回溯算法，每到达一个节点就使用全局变量记录出现次数，因为需要排除重复的字符，所以创建一个boolean数组，
 * 用来记录当前字符是否使用。对输入字符串按照字典序排序，如果当前字符与前一个字符相同且前一个字符没有使用过，则跳过该字符
 */
class Solution {
    int res = 0;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] flag = new boolean[chars.length];
        helper(chars, flag);
        return res;
    }

    private void helper(char[] chars, boolean[] flag) {
        for (int i = 0; i < chars.length; i++) {
            //如果等于当前值，跳出
            if (flag[i]) continue;
            //去重
            if (i > 0 && chars[i] == chars[i - 1] && !flag[i - 1]) continue;
            res++; //更新结果
            flag[i] = true;
            helper(chars, flag);
            //还原
            flag[i] = false;
        }
    }
}

public class $1079_LetterTilePossibilities {
}

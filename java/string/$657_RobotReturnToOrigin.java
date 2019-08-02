/**
 * 因为移动不分方向，所以只要机器人向上向下移动了相同步数、向左向右移动了相同步数，就回到了原地，直接判断字符串中U/D，L/R出现次数是否相等即可
 * 定义两个变量，up记录向上走的步数，left记录向左走的步数，当向下走时up--，向右走时left--
 * 最后判断这两个元素是否为0即可
 */
class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0, up = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') up++;
            else if (c == 'D') up--;
            else if (c == 'L') left++;
            else left--;
        }
        return up == 0 && left == 0;
    }
}

public class $657_RobotReturnToOrigin {
}

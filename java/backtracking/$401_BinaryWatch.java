import java.util.ArrayList;
import java.util.List;

/**
 * 因为灯亮时代表的数字为2,4,6,8..，转换为二进制则每个数字中只有一个1。
 * 直接暴力，从0:00遍历到11:59，判断里面小时位为1+分钟位为1的个数，如果等于num，则加入结果集
 */
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int hour = 0; hour <= 11; hour++) {
            for (int min = 0; min <= 59; min++) {
                if (bitCount(hour) + bitCount(min) == 1)
                    res.add(hour + "" + (min < 9 ? "0" + min : min));
            }
        }
        return res;
    }

    private int bitCount(int num) {
        int res = 0;
        while (num > 0) {
            num = num & (num - 1);
            res++;
        }
        return res;
    }
}


public class $401_BinaryWatch {
}

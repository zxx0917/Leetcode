package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果是非快乐数，最后平方和会出现循环，可以用一个集合来储存所有平方和，一旦有重复就返回false;
 */
public class $202_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            //计算平方和
            int sum = 0;
            while (n > 0) {
                int dig = n % 10;
                sum += dig * dig;
                n /= 10;
            }
            n = sum;
            if (set.contains(sum)) return false;
            set.add(sum);
            if (sum == 1) return true;
        }
    }
}

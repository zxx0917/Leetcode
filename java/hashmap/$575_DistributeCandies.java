package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 理论上妹妹最多能够获得candies.length/2种糖果，使用Set记录糖果实际有多少种类，
 * 如果实际种类>理论种类，则返回理论值，如果实际种类<理论种类，返回实际种类.
 */
public class $575_DistributeCandies {
    public int distributeCandies(int[] candies) {
        int theory = candies.length/2;
        Set<Integer> set = new HashSet<>();
        //获取糖果实际有多少种类
        for(int candy:candies){
            set.add(candy);
        }
        return set.size() > theory ? theory : set.size();
    }
}

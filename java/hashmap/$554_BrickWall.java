package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 穿过最少砖的直线肯定是穿过缝隙最多的线，所以可以遍历整个List，获取每一行每条缝隙对应的砖宽，
 * 将砖宽度和砖宽度出现的次数存入Map，最后遍历map获取出现次数最多的宽度，总行数-出现次数即为结果
 */
public class $554_BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                //计算每行砖缝的对应砖块宽度，将宽度和出现次数存入map
                sum += wall.get(i).get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        //获取出现次数最多的宽度，穿过这个宽度构成的缝即为结果
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        return wall.size() - max;
    }
}

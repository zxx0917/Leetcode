import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 首先计算出times[i]时胜利的person，保存到winner数组中，然后在q()方法中，在times数组中使用二分查找，找到对应的索引值i，
 * 然后返回winner[i]即可
 */
class TopVotedCandidate {
    //记录times[i]时的胜利者
    int[] winner;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        winner = new int[times.length];
        this.times = Arrays.copyOf(times, times.length);
        int nowWinner = persons[0];
        int voted = 1;
        //使用Map记录每个person的票数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(persons[0], 1);
        for (int i = 1; i < persons.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            //更新当前的票数最多的人
            if (voted <= map.get(persons[i])) {
                nowWinner = persons[i];
                voted = map.get(persons[i]);
            }
            winner[i] = nowWinner;
        }
    }

    public int q(int t) {
        //二分查找获得times的对应索引
        int left = 0, right = times.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (times[mid] == t) {
                return winner[mid];
            } else if (times[mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == 0 ? winner[left] : winner[left - 1];
    }
}

public class $911_OnlineElection {
}

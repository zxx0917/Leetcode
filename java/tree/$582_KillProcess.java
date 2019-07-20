import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将父节点和其下面所有子节点放入Map，形成父节点->子节点集合关系，然后在Map中找到kill和其子节点以及其后代放入结果集即可
 */
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        if (!pid.contains(kill)) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            int parent = ppid.get(i);
            List<Integer> list = map.get(parent);
            if (list == null) list = new ArrayList<>();
            list.add(pid.get(i));
            map.put(parent, list);
        }
        //获取kill在map中的子节点以及后代
        helper(kill, map, res);
        return res;
    }

    private void helper(int kill, Map<Integer, List<Integer>> map, List<Integer> res) {
        //加入根节点
        res.add(kill);
        if (!map.containsKey(kill)) return;
        List<Integer> childList = map.get(kill);
        for (int pid : childList) {
            helper(pid, map, res);
        }
    }
}

public class $582_KillProcess {
}

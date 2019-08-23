import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用拓扑排序，如果输入为：[[1,0],[0,1]]，则有向图方向为1<-0，0<-1，
 * 即prerequisites[0][1]为优先条件，prerequisites[0][0]为后置条件。
 * 具体拓扑排序解释和算法模板见：
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        int len = prerequisites.length;
        if (len == 0) return true;

        //创建一个入度数组
        int[] degrees = new int[numCourses];
        for (int i = 0; i < len; i++) {
            degrees[prerequisites[i][0]]++;
        }

        //创建一个队列储存入度为0的节点
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0)
                list.add(i);
        }

        //创建一个集合保存拓扑排序
        List<Integer> res = new ArrayList<>();
        while (!list.isEmpty()) {
            //弹出入度为0的节点
            int node = list.removeFirst();
            //加入拓扑排序结果
            res.add(node);
            //找到node的指向节点
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == node) {
                    degrees[prerequisites[i][0]]--;
                    //将为0的节点加入集合
                    if (degrees[prerequisites[i][0]] == 0) {
                        list.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return res.size() == numCourses;
    }
}

public class $207_CourseSchedule {
}

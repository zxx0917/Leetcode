import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 还是使用拓扑排序，方法同207题：https://github.com/JuiceZhou/Leetcode/blob/master/java/dfs/$207_CourseSchedule.java
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[]{};


        //1.构建入度数组
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
        }

        //2.将入度为0的点加入集合
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                list.add(i);
            }
        }

        //3.删除入度为0的节点，并将拓扑排序加入结果集
        List<Integer> res = new ArrayList<>();
        while (!list.isEmpty()) {
            int node = list.removeFirst();
            res.add(node);
            //删除对应节点的入度
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == node) {
                    degrees[prerequisite[0]]--;
                    if (degrees[prerequisite[0]] == 0) {
                        list.add(prerequisite[0]);
                    }
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[]{};
        } else {
            int[] arr = new int[numCourses];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }
    }
}

public class $210_CourseScheduleII {
}

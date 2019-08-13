/**
 * 使用回溯算法，剪枝条件为当前数不能被i整除或整除i。
 * 对于1~N个数，每次递归是从第一个数开始的，且不能取重复数，所以需要创建一个boolean[]对使用过的数进行记录
 * 如果当前数已经使用过则直接continue
 * 递归时使用count表示已经排列到第几个数，当count>N时表示一个排列完成，更新计数器，return
 */
class Solution {
    int res = 0;

    public int countArrangement(int N) {
        boolean[] flag = new boolean[N + 1];
        helper(flag, N, 1);
        return res;
    }

    //count表示已经排列到第几个数
    private void helper(boolean[] flag, int N, int count) {
        if (count == N + 1) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            //如果当前数已经使用过
            if (flag[i]) continue;
            //剪枝条件：如果不能被i或整除i
            if (i % count != 0 && count % i != 0) continue;
            flag[i] = true;
            helper(flag, N, count + 1);
            flag[i] = false;
        }
    }
}

public class $526_BeautifulArrangement {
}

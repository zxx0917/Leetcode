/**
 * 固定数组中的奇数位元素，如果它的下一个元素满足n+1或n-1，则代表这两个是一对，不需要处理，直接跳到下一个奇数元素
 * 如果奇数元素的下一个元素和情侣元素不相等，则记录情侣元素，在其后找到情侣元素的位置，将情侣元素与下一个元素交换，累积交换次数
 * 遍历完毕后就得到结果
 * 如0,3,2,1，0的情侣元素为1，而0的下一个元素为3，则找到1的位置，和3交换，得到0,1,2,3，跳到元素2，已经满足条件，遍历结束，一共交换了1次
 */
class Solution {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            int couple = getCouple(row[i]);
            if (couple != row[i + 1]) {
                //找到couple的位置
                int index = -1;
                for (int j = i + 2; j < row.length; j++) {
                    if (couple == row[j]) {
                        index = j;
                        break;
                    }
                }
                swap(row, index, i + 1);
                res++;
            }
        }
        return res;
    }

    private void swap(int[] row, int x, int y) {
        int tmp = row[x];
        row[x] = row[y];
        row[y] = tmp;
    }

    //如果是奇数则情侣为x-1，如果是偶数则情侣为x+1
    private int getCouple(int x) {
        return (x & 1) == 1 ? x - 1 : x + 1;
    }
}

public class $765_CouplesHoldingHands {
}

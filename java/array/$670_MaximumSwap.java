package array;

import java.util.Arrays;

/**
 * 将数字从大到小排列，与原数字比较，找出第一位置不一样的数
 * 如8217排序后变为8721，两两对比，第二个数不同，表示7和2交换，得到结果8712
 */
public class $670_MaximumSwap {
    public int maximumSwap(int num) {
        //1.排序数组元素
        char[] orderNum = Integer.toString(num).toCharArray();
        char[] oldNum = Integer.toString(num).toCharArray();
        Arrays.sort(orderNum);//这里是从小到大排列

        int diff = -1;
        //2.比较第一个不同的元素
        for (int i = 0; i < orderNum.length; i++) {
            if (oldNum[i] != orderNum[orderNum.length - 1 - i]) {
                diff = i;
                break;
            }
        }

        //两数相同，不需要交换
        if (diff == -1) return num;

        //两两交换
        for (int i = oldNum.length - 1; i >= diff; i--) {
            if (oldNum[i] == orderNum[orderNum.length - 1 - diff]) {
                //交换后直接跳出
                swap(oldNum, diff, i);
                break;
            }
        }

        return Integer.parseInt(new String(oldNum));
    }

    private void swap(char[] chars, int lo, int hi) {
        char tmp = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = tmp;
    }
}

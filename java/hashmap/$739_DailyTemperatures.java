/**
 * 从最后往前考虑，最后一个数肯定是0，对于倒数第二个数，如果T[T.length-2] < T[T.length-1]，则res[T.length-2]=1
 * 如果T[T.length-2] > T[T.length-1]，则res[T.length-2]=0
 * 推测到T[i]：
 * 如果T[i]<T[i+1]，则res[i]=1，
 * 如果T[i]>T[i+1]：1.如果res[i+1]=0，则res[i]=0；2.如果res[i+1]!=0，则比较T[i]和比T[i+1]温度高的那天的温度，即比较T[i]和T[i+1+res[i+1]]
 */
public class $739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        res[res.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }
}

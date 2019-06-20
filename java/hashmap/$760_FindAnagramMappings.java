package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用Map记录B数组元素的索引位置，然后遍历A数组，获取当前元素在B数组的索引位，放入结果数组中
 */
public class $760_FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] res = new int[A.length];
        Map<Integer,Integer> map = new HashMap<>();
        //将B数组元素和对应索引位放入Map
        for(int i = 0;i < B.length;i++){
            map.put(B[i],i);
        }
        for(int i = 0;i < A.length;i++){
            res[i] = map.get(A[i]);
        }
        return res;
    }
}

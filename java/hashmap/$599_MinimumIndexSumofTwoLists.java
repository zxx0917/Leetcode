package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 先将list1中的名称和对应索引位置加入Map，再遍历list2中元素，遇到相同的餐厅计算索引和并判断是否是最小，
 * 如果当前索引和小于最小值，则清空结果集，在将当前餐厅名加入结果集，并给最小值重新赋值；如果索引和和最小值相等，则直接加入List
 */
public class $599_MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> list = new ArrayList<>();
        int minIndex = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index = i + map.get(list2[i]);
                if(minIndex > index){
                    minIndex = index;
                    list.clear();
                    list.add(list2[i]);
                }else if(minIndex == index){
                    list.add(list2[i]);
                }

            }
        }
        return list.toArray(new String[list.size()]);
    }
}

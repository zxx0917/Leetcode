import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯算法。一共两种情况：1.不购买大礼包，都使用单价购买；2.可以购买大礼包，继续递归计算余下的商品是单个购买还是购买大礼包
 */
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs.size() == 0) return 0;
        //求出单个购买价格
        int cost = 0;
        for (int i = 0; i < price.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }
        //求出是否能购买大礼包
        for (int i = 0; i < special.size(); i++) {
            //判断是否能购买大礼包
            boolean flag = true;
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < special.get(i).get(j)) {
                    flag = false;
                    break;
                }
            }

            //可以购买大礼包
            if (flag) {
                List<Integer> newNeeds = new ArrayList<>();
                for (int j = 0; j < needs.size(); j++) {
                    //更新购买后的needs
                    newNeeds.add(needs.get(j) - special.get(i).get(j));
                }
                int money = shoppingOffers(price, special, newNeeds) + special.get(i).get(special.get(i).size()-1);
                cost = Math.min(cost, money);
            }
        }
        return cost;
    }
}

public class $638_ShoppingOffers {
}

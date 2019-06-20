package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对于不同的域名，使用HashMap来统计子域名出现的次数，最后遍历Map获得结果即可
 */
public class $881_SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if(cpdomains.length == 0) return res;
        Map<String,Integer> map = new HashMap<>();
        for(String cpdomain:cpdomains){
            String[] splits = cpdomain.split(" ");
            int count = Integer.valueOf(splits[0]);
            String domain = splits[1];
            //分别给不同的域名记录次数
            String[] domains = domain.split("\\.");
            //每个域名地址包含一个或两个.
            map.put(domain,map.getOrDefault(domain,0)+count);
            map.put(domains[domains.length-1],map.getOrDefault(domains[domains.length-1],0)+count);
            if(domains.length == 3){
                String key = domains[1]+"."+domains[2];
                map.put(key,map.getOrDefault(key,0)+count);
            }
        }
        //遍历Map，得到结果
        for(String key : map.keySet()){
            res.add(map.get(key)+" "+key);
        }
        return res;
    }
}

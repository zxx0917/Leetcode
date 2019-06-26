package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用Map储存"文件内容"->"对应的文件路径"，有相同文件内容的路径存入List，
 * 最后遍历Map vaule，判断List.size()>1，如果>1则表示有重复文件
 */
public class $609_FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if(paths.length == 0) return res;
        //储存 "文件内容"->对应的文件路径
        Map<String,List<String>> map = new HashMap<>();
        for(String path : paths){
            //路径、文件、文件
            String[] fields = path.split(" ");
            String directortPath = fields[0];
            for(int i = 1;i < fields.length;i++){
                // 1.txt abcd)
                String[] strs = fields[i].split("\\(");
                //文件内容
                String content = strs[1].substring(0,strs[1].length()-1);
                String totalPath = directortPath+"/"+strs[0];
                List<String> totalPathList = map.get(content);
                if(totalPathList == null)
                    totalPathList = new ArrayList<>();
                //放入map
                totalPathList.add(totalPath);
                map.put(content,totalPathList);
            }
        }

        //遍历map，获取结果
        for (List<String> list : map.values()) {
            //表示有重复文件
            if(list.size() > 1)
                res.add(list);
        }
        return res;
    }
}

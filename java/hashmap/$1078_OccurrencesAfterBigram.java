import java.util.ArrayList;
import java.util.List;

//分句子，找到first出现的位置，在判断之后是否是second，如果是则之后的单词就是third
public class $1078_OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] words = text.split(" ");
        for(int i = 0;i < words.length-2;i++){
            if(words[i].equals(first) && i < words.length-2 && words[i+1].equals(second)){
                list.add(words[i+2]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}

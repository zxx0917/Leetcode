package array;

/**
 * 根据题意知，首先需要对年龄进行排序，除了自己以外只有大于自己的元素才能发送好友请求。
 * 因为1<=age<=120，所以可以创建一个length为121的数组，统计所有年龄出现的次数，这样可以有效的减少循环的次数
 *
 * 注意两点：
 * 1. 年龄相等也可以给同龄人发送请求
 * 2. 15岁以下不能交友
 */
public class $_FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        if (ages.length <= 1) return 0;
        //1.统计每个年龄的人数
        int[] people = new int[121];
        for (int age : ages) {
            people[age]++;
        }

        //2.按照年龄从小到大，只能后面元素向前面元素发送请求
        int res = 0;
        //3.固定一个元素，统计大于等于这个元素的元素给它发送的好友请求总和
        for (int i = 15; i < people.length; i++) {
            for (int j = i; j < people.length; j++) {
                if (i <= 0.5 * j + 7)
                    break;
                else{
                    if(i == j){
                        res += people[i] * (people[j]-1);
                    }else{
                        res += people[i] * people[j];
                    }
                }
            }
        }

        return res;
    }
}

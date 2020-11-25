package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: Code406
 * Description:
 *
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。
 * 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
 *
 *
 * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
 *
 * 示例：
 *
 * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 * 提示：
 *
 * 总人数少于 1100 人。
 *
 * @author zxw
 * @date 2020/11/24 9:52 上午
 * @since JDK 1.8
 */
public class Code406 {

    /**
     * 解题思路：
     * （h,k),h表示身高，k表示前面且身高大于等于h的人数
     *  既然要满足￿对人数k的要求，那么自然需要知道身高大于等于自己身高的有多少人
     *  那么可以对身高h进行从大到小排序，如果身高h相等，那么k越小的人优先排在前面
     *  此时排完序后每个人的数组下标n就是前面有n个人比自己高
     *  则将n和k对比，若n>k,则将该人向前移动n-k个位置。即将下标为n-k到n-1的人往后移动一位，n-k位置由下标为n的人代替
     *  备注：将人往前移动并不会影响后面的人，因为前面的人身高就是比你高，前面怎么移动都会有固定的人数比你高
     * @param people
     * @return
     */
    public static  int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? 1 : (o1[0] == o2[0]) ? ((o1[1] < o2[1]) ? -1 : 1) : -1;
            }
        });
        for (int i = 0; i < people.length; i++){
            if (i > people[i][1]){
                move(people,i,i-people[i][1]);
            }
        }
        return people;
    }

    public static void move(int[][] people,int index,int moveLen){
        int[] moveValue = people[index];
        for (int i = index; i > index-moveLen; i--){
            people[i] = people[i-1];
        }
        people[index-moveLen] = moveValue;
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ints = reconstructQueue(people);

        List<Integer> queue = new ArrayList<>();
        //该方法实现插入功能。
        queue.add(0,0);
        queue.add(1,2);
        queue.add(0,3);
        queue.add(2,5);

        System.out.println(reconstructQueue(people));
    }
}

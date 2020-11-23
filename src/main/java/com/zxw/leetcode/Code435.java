package main.java.com.zxw.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Code435
 * Description:
 *
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zxw
 * @since JDK 1.8
 */
public class Code435 {

    /**
     * 思路：
     * 需要移出的最小区间个数 = 总区间个数 - 符合区间不重叠的最大区间个数
     * 要实现符合区间不重叠的最大区间个数，则应考虑每个区间结尾（只有区间结尾越小，留个后面的区间的空间就越大）
     * 根据区间结尾进行排序，区间结尾小的优先使用
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : (o1[1] == o2[1]) ? 0 : 1;
            }
        });
        int end = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < end){
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;

    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2},{1,3},{2,3},{3,4},{2,5},{5,6},{4,6}};
        System.out.println(eraseOverlapIntervals(arr));
    }
}

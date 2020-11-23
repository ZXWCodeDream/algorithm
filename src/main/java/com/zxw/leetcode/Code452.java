package main.java.com.zxw.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Code452
 * Description:
 *
 *
 * 452. 用最少数量的箭引爆气球
 *
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zxw
 * @date 2020/11/23 10:54 上午
 * @since JDK 1.8
 */
public class Code452 {

    /**
     * 思路：
     * 射出的最小弓箭数 --转化理解为--》 重复的区间只射击一箭，则求组成区间不重复的最大数量（这些区间就只能射击一箭，剩下的区间都会跟这些区间有重叠，所以组成区间不重复的最大数量即射出 的最小弓箭数）
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : (o1[1] == o2[1]) ? 0 : 1;
            }
        });
        int cnt  = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++){
            if (points[i][0] <= end){
                continue;
            }
            end = points[i][1];
            cnt++;
        }
         return cnt;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{2,3}};
        System.out.println(findMinArrowShots(arr));
    }
}

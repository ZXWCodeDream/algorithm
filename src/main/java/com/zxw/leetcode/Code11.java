package main.java.com.zxw.leetcode;

/**
 * ClassName: Code11
 * Description:
 *11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zxw
 * @date 2020/11/12 11:08 下午
 * @since JDK 1.8
 */

public class Code11 {

    /**
     * 思路:
     *  容器所能容纳的最多的水，即求组成的面积最大
     *
     *  暴力：
     *      Max((j-i)*Min(height[i],height[j]))
     *  优化双指针:
     *      首先使得i=0,j=height.lenght-1; 使得（j-i）最大,面积为S(i,j)
     *      此时影响面积的因素主要在于 Min(height[i],height[j]),即最小的那一个
     *      若 height[i] < height[j],则使得i++,(此时抛去计算的数据有S(i,j-1)、S(i,j-2)....S(i,i+1),x轴间距越来越小，y轴间距最大就是height[i],所以这些面积肯定比S(i,j)下，所以左指针右移合理)
     *      反之 j--
     *
     * @param height
     * @return
     */
    public  static int maxArea(int[] height) {

        int l = 0,r = height.length-1;
        int result = (r-l)*Math.min(height[l],height[r]);
        while (l < r){
            result = height[l] < height[r] ? Math.max(result,(r-l-1)*Math.min(height[++l],height[r])) :  Math.max(result,(r-l-1)*Math.min(height[l],height[--r]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,18,17,6};
        System.out.println(maxArea(arr));
    }
}

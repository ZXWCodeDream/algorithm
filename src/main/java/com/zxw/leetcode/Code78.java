package main.java.com.zxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Code78
 * Description:
 *
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author zxw
 * @date 2021/2/26 2:50 下午
 * @since JDK 1.8
 */
public class Code78 {

    /**
     * 使用二进制解决子集问题
     * 方法：
     * 1、将每一个元素从0开始标定序号：0、1、2、3、4、5...
     * 2、用二进制每一位代表每一个元素。二进制位为1，代表这个坐标的元素存在，为0，代表这个坐标的元素不存在
     * 3、使用默认公式：
     * subset = n;
     * do{
     *     //做业务操作
     *     subset = (subset - 1) & n; //子集
     * }while(subset != n)
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            n |= 1 << i;
        }

        int subset = n;
        do{

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++){
                if ((subset & (1 << i)) == (1 << i)){
                    list.add(nums[i]);
                }
            }
            result.add(list);
            subset = (subset-1) & n;

        }while(subset != n);


        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> list : subsets){
            System.out.println();
            for (Integer num : list){
                System.out.print(num+",");
            }
        }
    }
}

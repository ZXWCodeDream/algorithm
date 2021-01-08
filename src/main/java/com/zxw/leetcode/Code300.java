package main.java.com.zxw.leetcode;

/**
 * ClassName: Code300
 * Description:
 *
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：
 *
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * @author zxw
 * @date 2021/1/8 3:40 下午
 * @since JDK 1.8
 */
public class Code300 {

    /**
     * 状态转移方程：
     *   dp[i] = Max(dp[j])+1 | 0 <= j < i && nums[j] < nums[i]
     * 解释：
     *   对于前i个数的最长递增子序列，肯定需要找到比i小的并且dp值最大的数 +1
     *   举例对于0103(s1代表最长递增子序列，l代表最长递增子序列长度)
     *   0：s1=0,l=1
     *   1：s1=01,l=2
     *   0: s1=0,l=1
     *   3: s1可以是03，13，013。最长的则需要找到比3小的且s1最大的值+1，即当s1=01,l=2时，l=2+1=3
     *
     * dp[i]数组含义：
     *  代表前i个连续递增子序列最长长度。
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int maxNum = 0;
        for (int i = 0; i < n; i++){
            int max = 0;
          for (int j = i- 1; j >= 0; j--){
              if (nums[j] < nums[i]){
                  max = Math.max(max,dp[j]);
              }
          }
          dp[i] = max+1;
          maxNum = Math.max(dp[i],maxNum);
        }
        return maxNum;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int[] arr1 = new int[]{0,1,0,3,2,3};
        int[] arr2 = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arr));
        System.out.println(lengthOfLIS(arr1));
        System.out.println(lengthOfLIS(arr2));
    }
}

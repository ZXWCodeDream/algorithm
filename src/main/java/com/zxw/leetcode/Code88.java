package main.java.com.zxw.leetcode;


/**
 * ClassName: Code88
 * Description:
 *
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * @author zxw
 * @date 2021/3/17 5:23 下午
 * @since JDK 1.8
 */
public class Code88 {

    /**
     * 从num1数组尾部开始插入
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0){
            return;
        }

        boolean flag = true;
        for (int i = 1,j = 1; i < m || j < n; i++,j++){
            if ((i < m && nums1[i] > nums1[i-1]) || (j < n && nums2[j] > nums2[j-1])){
                break;
            }else if ((i < m && nums1[i] < nums1[i-1]) || (j < n && nums2[j] < nums2[j-1])){
                flag = false;
                break;
            }
        }


        int i = m-1,j = n-1;
        int k = m+n-1;
        while (i >= 0 && j >= 0){
            if (flag){
                if (nums1[i] >= nums2[j]){
                    nums1[k] = nums1[i];
                    k--;i--;
                }else{
                    nums1[k] = nums2[j];
                    k--;j--;
                }
            }else{
                if (nums1[i] <= nums2[j]){
                    nums1[k] = nums1[i];
                    k--;i--;
                }else{
                    nums1[k] = nums2[j];
                    k--;j--;
                }
            }
        }
        if (j >= 0){
            while (j >= 0){
                nums1[k] = nums2[j];
                k--;j--;
            }
        }

    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1,0,nums2,1);
        for (int num : nums1){
            System.out.println(num);
        }
    }

}

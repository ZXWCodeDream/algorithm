package main.java.com.zxw.leetcode;

/**
 * ClassName: Code540
 * Description:
 *
 * 540. 有序数组中的单一元素
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * @author zxw
 * @date 2020/12/3 9:32 上午
 * @since JDK 1.8
 */
public class Code540 {

    /**
     * 二分
     * 解题思路：
     * 题目描述有序数组，每个元素都会出现两次，唯有一个数只会出现一次
     * 可知数组长度必定是奇数，那么对数组长度任意切割，只要长度是奇数的就会存在这个唯一的数
     * 因此进行二分切割
     * 二分切割后需要判断唯一的数是在左边还是右边
     * 当中间值mid是奇数时，那么其左右两边存在奇数个数字，通过将该mid位置的值和左右相邻的值进行比较，若等于右边相邻的，那么数存在[l,mid-1],若等于左边相邻的，那么数存在[mid+1,r]
     * 当中间值mid是偶数时，那么其左右两边存在偶数个数字，通过将该mid位置的值和左右相邻的值进行比较，若等于右边相邻的，那么数存在[mid+2,r],若等于左边相邻的，那么数存在[l,mid-2]
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {

        int l = 0, r = nums.length-1;
        int mid;
        while (l < r){
            mid = (r-l)/2+l;
            if (mid%2 == 0){
                if (nums[mid] == nums[mid-1]){
                    r = mid-2;
                }else if (nums[mid] == nums[mid+1]){
                    l = mid+2;
                }else{
                    return nums[mid];
                }
            }else{
                if (nums[mid] == nums[mid-1]){
                    l = mid+1;
                }else if (nums[mid] == nums[mid+1]){
                    r = mid-1;
                }else{
                    return nums[mid];
                }
            }

        }
        return nums[l];
    }




}

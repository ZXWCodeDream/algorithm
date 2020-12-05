package main.java.com.zxw.leetcode;

/**
 * ClassName: Code153
 * Description:
 *
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 * @author zxw
 * @date 2020/12/5 9:44 下午
 * @since JDK 1.8
 */
public class Code153 {

    public int findMin(int[] nums) {

        int l = 0,r = nums.length-1;
        int mid;
        while (l < r){
            mid = (r-l)/2+l;
            if (nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return nums[l];
    }
}

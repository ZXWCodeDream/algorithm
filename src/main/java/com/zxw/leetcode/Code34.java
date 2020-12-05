package main.java.com.zxw.leetcode;

/**
 * ClassName: Code34
 * Description:
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author zxw
 * @date 2020/12/5 9:42 下午
 * @since JDK 1.8
 */
public class Code34 {

    public int[] searchRange(int[] nums, int target) {


        int l = 0, r = nums.length-1;
        int mid = -1;
        int[] result = new int[]{-1,-1};
        int min = -1,max = -1;
        while (l <= r){
            mid = (r-l)/2+l;
            if (nums[mid] > target){
                r = mid-1;
            }else if (nums[mid] < target){
                l = mid+1;
            }else{
                break;
            }
        }
        if (l > r){
            return result;
        }
        if (mid != -1 && nums[mid] == target){
            int tmp = mid;
            if (nums[l] == target){
                result[0] = l;
            }else{
                while (l<=tmp){
                    if (nums[tmp] != target){
                        break;
                    }
                    tmp--;
                }
                if (tmp >= l){
                    result[0] = tmp+1;
                }
            }

            int tmp1 = mid;
            if (nums[r] == target){
                result[1] = r;
            }else{
                while (tmp1 <= r){
                    if (nums[tmp1] != target){
                        break;
                    }
                    tmp1++;
                }
                if (tmp <= r){
                    result[1] = tmp1-1;
                }
            }

        }
        return result;
    }
}

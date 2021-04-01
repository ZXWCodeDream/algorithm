package main.java.com.zxw.leetcode;

import main.java.com.zxw.common.Util;

/**
 * ClassName: Code283
 * Description:
 *
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zxw
 * @date 2020/11/20 8:16 下午
 * @since JDK 1.8
 */
public class Code283 {

    public static void move(int[] nums){

        // 写指针
        int i = 0;
        //读指针
        for (int j = 0; j < nums.length; j++){
            //读指针一直往后移，直到遇到非0数值，将其与写指针所在位置交换
            if (nums[j] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                //写指针后移一位
                i++;
            }
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,0,1,2,0,1,0};
        move(nums);
        Util.print(nums);
    }

    /**
     * 思路：
     * 定义i为实时最前面值为0的下标
     * 定义j为实时遍历数组比较值的下标
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        for (int i = 0,j=0; j < nums.length;){
            //当i和j指针指向同一个元素，且值都为0时
            if (nums[j] == 0 && i == j){
                i = j;j++;
            }else if (nums[j] == 0 && i != j){
                j++;
            } else if (nums[j] != 0 && i == j){
                i++;j++;
            }else if (nums[j] != 0 && i != j){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;j++;
            }
        }
    }
}

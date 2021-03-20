package main.java.com.zxw.leetcode;

/**
 * ClassName: Code136
 * Description:
 *  136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 * @author zxw
 * @date 2021/3/20 12:45 下午
 * @since JDK 1.8
 */
public class Code136 {

    /**
     * 位运算：^ 异或
     * 两个相等的值进行异或等于0
     * 0与任何值进行异或等于该值本身
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int n = nums[0];
        for (int i = 0; i < nums.length; i++){
            n ^= nums[i];
        }
        return n;
    }
}

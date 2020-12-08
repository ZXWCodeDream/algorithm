package main.java.com.zxw.leetcode;

/**
 * ClassName: Code169
 * Description:
 *
 *
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author zxw
 * @date 2020/12/7 4:52 下午
 * @since JDK 1.8
 */
public class Code169 {


    /**
     * 分治法：分而治之，将一个问题拆分成多个子问题，多个子问题的解的合并就是原问题的解
     * 思路：
     * 以下n表示各个区域范围内的数组长度，并不唯一，是统称
     * 既然数组中一定存在出现次数大于n/2的元素，那么对半拆分成两个区域[l,mid],(mid,r]。l = 0,r = nums.length-1;
     * 区域[l,mid],(mid,r]一定会有一个区域存在次数大于n/2的元素,这就把原问题拆分成多个子问题求解啦
     * 那么现在[l,mid]和[mid,r]区域可能都会有各自存在的次数大于n/2的元素，那么该选择那个呢？这就是解决子问题的解合并成原问题的解
     * 合并成原问题解的方案是：将左右两个区间[l,mid],(mid,r]找到的值在合并的区间[l,r]内去寻找重复的数量,寻找大于n/2的那个值，返回即可。
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        int l = 0, r = nums.length-1;
        int index =  getTargetElement(nums,l,r);
        return nums[index];

    }

    /**
     * 寻找指定区间范围内重复次数大于n/2的元素的下标，若不存在则返回-1
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int getTargetElement(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }else  if (l == r){ // 只有一个元素，则返回当前元素的下标
            return l;
        }else if (r - l == 1){ // 有两个元素时，只有两个值相等时，返回这个值的下标
            if (nums[l] == nums[r]){
                return l;
            }else{
                return -1;
            }
        }
        int m = (r-l+1)/2+l;
        int left = getTargetElement(nums,l,m); // 寻找左区间的目标值
        int right = getTargetElement(nums,m+1,r); // 寻找右区间的目标值
        if (left != -1 && isTargetElement(nums,l,r,nums[left])){
            return left;
        }else if (right != -1 && isTargetElement(nums,l,r,nums[right])){
            return right;
        }else{
            return -1;
        }

    }

    private static Boolean isTargetElement(int[] nums,int l,int r,int target){
        int n = (r-l+1)/2;
        for (int i = l; i <= r; i++){
            if (target == nums[i]){
                n--;
            }
        }
        return n < 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        System.out.println(majorityElement(arr));
    }


}

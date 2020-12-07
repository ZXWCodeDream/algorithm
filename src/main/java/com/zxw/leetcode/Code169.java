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

    public static int majorityElement(int[] nums) {

        int l = 0, r = nums.length-1;
        int index =  getTargetElement(nums,l,r);
        return nums[index];

    }

    private static int getTargetElement(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }else  if (l == r){
            return l;
        }else if (r - l == 1){
            if (nums[l] == nums[r]){
                return l;
            }else{
                return -1;
            }
        }
        int m = (r-l+1)/2+l;
        int left = getTargetElement(nums,l,m);
        int right = getTargetElement(nums,m+1,r);
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

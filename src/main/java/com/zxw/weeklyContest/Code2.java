package main.java.com.zxw.weeklyContest;

import java.util.*;

/**
 * ClassName: Code2
 * Description:
 *
 * @author zxw
 * @date 2021/1/17 10:39 上午
 * @since JDK 1.8
 */
public class Code2 {

    /**
     * 思路：
     * 1、正常暴力 4层循环超时，时间复杂度O(n^4)
     * 只要找到其中四个能组成a*b=c*d，即可知道其存在8个组合。
     * 2、双指针，先确定两个位置，再通过双指针寻找，时间复杂度O(n^3),超时
     * 3、使用哈希表记录乘积，记录两两数乘积，时间复杂度O(n^2),可行
     * 若两两数乘积次数n大于等于2，则可存在(n-1)!种组合组成a*b=c*d
     * 举例：两两数乘积和为2：则该四个数即可组成a*b=c*d
     *      两两数乘积和为3：则对这3对数进行排列组合，存在3*2/2种组合组成a*b=c*d
     * @param nums
     * @return
     */
    public static int tupleSameProduct(int[] nums) {

        if (nums == null || nums.length < 4){
            return  0;
        }
        int n = nums.length;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int result = nums[i] * nums[j];
                if (map.containsKey(result)){
                    map.put(result,map.get(result)+1);
                }else{
                    map.put(result,1);
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == 2){
                count++;
            }else if (entry.getValue() > 2){
                count += entry.getValue()*(entry.getValue()-1)/2;
            }
        }


        return count*8;
    }

    public static void main(String[] args) {
         int[] arr= new int[]{2,3,4,6,8,12};
        System.out.println(tupleSameProduct(arr));
    }

}

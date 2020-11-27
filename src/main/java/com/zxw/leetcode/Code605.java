package main.java.com.zxw.leetcode;

/**
 * ClassName: Code605
 * Description:
 *
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * @author zxw
 * @date 2020/11/27 10:21 上午
 * @since JDK 1.8
 */
public class Code605 {

    /**
     * 首先强调临界点：
     * 1、考虑传参函数：n==0时返回true,数组是否为空，是否有值
     * 2、当前位置在最左边，考虑右边是否为0，是0，则可以在当前位置种花
     * 3、当前位置在最右边，考虑左边是否为0，是0，则可以在当前位置种花
     * 4、数组只有一个值，可以种花
     *
     * 思路：只考虑当前的这块地种不种树即可，种树就种上树赋值为1
     * 种树的要求：
     *  当前值为0，左右两边都为0
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0){
            return true;
        }
        if (flowerbed == null || flowerbed.length == 0){
            return false;
        }
        int maxN = 0;
        for (int i = 0; i < flowerbed.length; i++){
            if (flowerbed[i] == 0){
//                if ((i+1 == flowerbed.length && i-1>=0 && flowerbed[i-1] == 0)
//                        || (i-1 < 0 && i+1 < flowerbed.length && flowerbed[i+1] == 0)
//                        || (i-1 >= 0 && i+1 < flowerbed.length && flowerbed[i-1] == 0 && flowerbed[i+1] == 0)
//                        || i+1 == flowerbed.length && i-1 < 0 ){
//                    maxN++;
//                    flowerbed[i] = 1;
//                    if (maxN == n){
//                        return true;
//                    }
//                }
                /**
                 * 代码优化：临界值考虑更清晰
                 */
                int left = i == 0 ? 0 : flowerbed[i-1];
                 int right = i == flowerbed.length-1 ? 0 : flowerbed[i+1];
                 if (left == 0 && right == 0){
                     maxN++;
                     flowerbed[i] = 1;
                     if (maxN == n){
                         return true;
                     }
                 }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0};
        System.out.println(canPlaceFlowers(arr,1));

    }
}

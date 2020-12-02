package main.java.com.zxw.leetcode;

/**
 * ClassName: Code744
 * Description:
 *
 *
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *
 *
 * 示例：
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *
 *
 * 提示：
 *
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * @author zxw
 * @date 2020/12/2 9:16 上午
 * @since JDK 1.8
 */
public class Code744 {

    /**
     * 二分法
     * 因为给定的letters是有序的，又是查找具体值，那么就可以通过二分查找
     * 定义左边界l,右边界r,取中间的值mid=(r-l)/2+l，
     * 若中间值大于目标值，则缩小范围到[l,mid],此时mid的值一定是大于目标值，符合条件的，但还要寻找大于目标值的最小值，所以得继续往左区域寻找
     * 若中间值小于等于目标值，则缩小范围到(mid,r],此时左边区域不符合条件，所以得从右边区域开始寻找
     *
     * 等二分查找结束,l、r都有可能是要寻找的值，需要进行比较，l优先r比较，若都不符合，则返回字母数组的首位
     *
     *
     * 重点：
     * 下面说说中间值mid的取值吧
     * 正常来说mid=(r-l)/2+l，而不是mid=(l+r)/2是避免超过int值范围
     * 有时我们又能看到mid=(r-l+1)/2+l这样赋值，本质其实=(l+r)/2+1/2，即向上取整
     * 那为什么要向上取整呢？
     * 举例：mid的值不符合条件的，即r=mid-1或者l=mid+1,则若l=0,r=1,默认向下取整mid=0,那么l=1或者r=-1，r的取值就越界了
     *
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {

        int l = 0,r = letters.length-1;
        int mid;
        //因为此时对于l和r的取值都为mid，没有+1，-1操作，那么去中间值得时候r永远都会比l大1。所以退出条件为l+1<r。其余条件都会死循环
        while (l+1 < r){
            //+1实际+1/2,目的向上取整
            //mid = (r-l+1)/2+l;
            // 由于此题r=mid而不是mid-1,所以不必向上取整
            mid = (r-l)/2+l;
            if (letters[mid] > target){
                // 此时mid所在的值是符合条件的，所以不能-1
                r = mid;
            }else{
                l = mid;
            }
        }
        //左边l的值一定比右边r的值小，所以优先考虑左边的值
        if (letters[l] > target){
            return letters[l];
        }else if (letters[r] > target){
            return letters[r];
        }else{
            return letters[0];
        }
    }

    public static void main(String[] args) {

        char[] arr = new char[]{'c', 'f', 'j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(arr,target));
    }
}

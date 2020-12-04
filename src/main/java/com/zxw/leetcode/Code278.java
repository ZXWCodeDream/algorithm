package main.java.com.zxw.leetcode;

/**
 * ClassName: Code278
 * Description:
 *
 *
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 *
 * startime:2020年12月04日09:28:06
 * endtime:2020年12月04日09:36:01
 * @author zxw
 * @date 2020/12/4 9:27 上午
 * @since JDK 1.8
 */
public class Code278 {

    /**
     * 二分
     * 范围[l,r]折半查找m，当中间位置是错误版本时，让搜索范围更新为[l,m],若中间位置是正确版本时，让搜索范围更新为[m+1,r]
     * 最终首次出错的版本自然为版本l
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {

        int l = 1,r = n;
        int m;
        while (l < r){
            m = (r-l)/2+l;
            if (isBadVersion(m)){
                r = m;
            }else{
                l = m+1;
            }

        }
        return l;

    }

    public static boolean isBadVersion(int version){
//        if (version <= 3){
//            return false;
//        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}

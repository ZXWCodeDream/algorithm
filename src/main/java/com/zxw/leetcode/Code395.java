package main.java.com.zxw.leetcode;


/**
 * ClassName: Code395
 * Description:
 *
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 * @author zxw
 * @date 2021/2/27 5:04 下午
 * @since JDK 1.8
 */
public class Code395 {

    /**
     * 分治算法
     *  给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k。
     *  找到字符串s中所有字符出现的个数，若字符ch个数小于k，则最长连续字段一定不包含该字符ch。
     *  也就是说，我们将字符串按照 ch 切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。因此，可以考虑分治的方式求解本题。
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring(String s, int k) {

        return dfs(s,k);
    }

    public static int dfs(String s,int k){

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }

        String  split = "";
        for (int i = 0; i < 26; i++){
            if (arr[i] > 0 && arr[i] < k){
                split = String.valueOf((char)(i+'a'));
                break;
            }
        }
        if (split.equals("")){
            return s.length();
        }

        String[] splitArr = s.split(split);
        int max = 0;
        for (String str : splitArr){
            int m = dfs(str,k);
            max = Math.max(max,m);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb",3));
    }
}

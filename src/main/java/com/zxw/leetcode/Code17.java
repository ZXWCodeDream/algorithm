package main.java.com.zxw.leetcode;

import java.util.*;

/**
 * ClassName: Code17
 * Description:
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
 * @author zxw
 * @date 2021/1/5 7:34 下午
 * @since JDK 1.8
 */
public class Code17 {

    private  static Set<String> result = new HashSet<>();

    /**
     *  回溯算法
     *  关键三步：
     *  1、可选择列表
     *  2、走过的路径
     *  3、结束条件
     *
     *  针对关键三步本题策略如下：
     *  对于给定字符串"23"
     *  可选择列表： 按顺序前进，当选择2时，可选字符串为"a","b","c"。当选择3时，可选字符串为"d","e","f"
     *  走过路径： 路径作为参数擦混入递归方法中，当选择2时，sb.append()追加"a","b","c"三个其中一个,进行递归，递归结束后，删除选择sb.delete()
     *  结束条件： 当走过路径的长度 = 给定字符串长度时退出递归，保留走过路径
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.equals("")){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<String,List<String>>(){{
            put("2", Arrays.asList("a","b","c"));
            put("3", Arrays.asList("d","e","f"));
            put("4", Arrays.asList("g","h","i"));
            put("5", Arrays.asList("j","k","l"));
            put("6", Arrays.asList("m","n","o"));
            put("7", Arrays.asList("p","q","r","s"));
            put("8", Arrays.asList("t","u","v"));
            put("9", Arrays.asList("w","x","y","z"));
        }};

        List<List<String>> selectors = new ArrayList<>();

        String[] nums = digits.split("");
        for (String num : nums){
            selectors.add(map.get(num));
        }
        StringBuilder sb = new StringBuilder();

        backTrack(selectors,sb);

        return new ArrayList<>(result);

    }

    public static void backTrack(List<List<String>> selectors,StringBuilder sb){

        if (sb.length() == selectors.size()){
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < selectors.get(sb.length()).size(); i++){
            sb.append(selectors.get(sb.length()).get(i));
            backTrack(selectors,sb);
            sb.delete(sb.length()-1,sb.length());
        }
    }

    public static void main(String[] args) {

        List<String> strings = letterCombinations("");
        strings.forEach(System.out::println);
    }
}

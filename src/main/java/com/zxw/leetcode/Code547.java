package main.java.com.zxw.leetcode;

/**
 * ClassName: Code547
 * Description:
 * 547. 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出：2
 * 解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回 2 。
 * 示例 2：
 *
 * 输入：
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出：1
 * 解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
 *
 *
 * 提示：
 *
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 * @author zxw
 * @date 2020/12/18 2:38 下午
 * @since JDK 1.8
 */
public class Code547 {

    /**
     * dfs深度优先搜索
     * 遍历学生，对每一个学生寻找他的朋友，匹配规则为:
     * 若这个人坐标为（j,j）则查找横坐标为j的所有位置值是否为1，若为1则表明他们两人是朋友。
     * 假设坐标为（j,m）,则该人坐标为（m,m）,遍历查找横坐标为m的所有位置，继续寻找朋友关系
     * @param M
     * @return
     */
    public static int findCircleNum2(int[][] M) {

        int count = 0;
        for (int i = 0; i < M.length; i++){
            if (M[i][i] == 1){
                dfs2(M,i,i);
                count++;
            }
        }
        return count;
    }

    public static void dfs2(int[][] M,int i, int j){
        if (M[i][j] == 0){
            return;
        }
        // 将关联标志清空
        M[i][j] = 0;
        // 将该人标识清空，表示这人的关系已经查找过了
        M[j][j] = 0;
        //寻找（j,j）用户的关系网，即寻找以j为横坐标的所有关系标识
        for (int m = 0; m < M[0].length; m++){
            dfs2(M,j,m);
        }
    }

    /**
     * 思路：dfs
     * 该二维数组可以看成是邻接矩阵，图的顶点编号表示矩阵M的下标。顶点i和j有且仅有一条边当且仅当M[i][j]=1时，使用boolean[M.length] visited标识顶点是否走过
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {

        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++){
            if (!visited[i]){
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }

    //寻找与i同学有关系的同学
    public static void dfs(int[][] M,boolean[] visited,int i){

        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(M,visited,j);
            }
        }
    }



    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}};

        int[][] arr2 = new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};
        System.out.println(findCircleNum(arr));
    }
}

# 算法

## 分治算法

**概念**

分治法：分而治之，将一个问题拆分成多个子问题，多个子问题解的合并就是原问题的解。

![image-20201207112314084](/Users/zhengxingwang/Library/Application Support/typora-user-images/image-20201207112314084.png)

**应用**

**快速排序**

**归并排序**





## 广度优先搜索BFS

**概念**

>广度优先搜索，别名BFS，属于一种盲目搜索法，目的是系统地展开并检查图中的所有节点。
>
>简单思路表达：将能走一步的所有节点都放入队列中，依次遍历寻找是否满足目标节点，若不满足目标节点，则弹出队列元素，并将该元素的下一个节点(同样走一步所到达的节点)放入队列中。**特别注意：走过的节点需要标识，不能重复走**



### 752 打开转盘锁

[LeetCode752 【打开转盘锁】](https://leetcode-cn.com/problems/open-the-lock/) *Medium*

**解题思路**：

BFS，将0000放入队列中，将旋转一次波轮的所有锁值放入队列中，依次寻找遍历。

可以使用Set<String> 标识已经走过的密码

每次旋转一次波轮可能的情况可以通过for循环实现

for (int i = 0; i < 4; i++){ //代表四个波轮转盘

​	for (int j = -1; j <= 1; j+=2){ //代表每次只能+1或者-1

​	}

}

```java
    public static int openLock(String[] deadends, String target) {

        if (target.equals("0000")){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        int step = 0;
        boolean[][][][] tag = new boolean[10][10][10][10];
        for (String s : deadends){
            int s_1 = Integer.valueOf(s.substring(0,1));
            int s_2 = Integer.valueOf(s.substring(1,2));
            int s_3 = Integer.valueOf(s.substring(2,3));
            int s_4 = Integer.valueOf(s.substring(3,4));
            tag[s_1][s_2][s_3][s_4] = true;
            if (s_1 == 0 && s_2 == 0 && s_3 == 0 && s_4 == 0){
                return -1;
            }
        }

        int[] move1 = new int[]{1,-1,0,0,0,0,0,0};
        int[] move2 = new int[]{0,0,1,-1,0,0,0,0};
        int[] move3 = new int[]{0,0,0,0,1,-1,0,0};
        int[] move4 = new int[]{0,0,0,0,0,0,1,-1};

        while(!queue.isEmpty()){

            step++;
            int size = queue.size();
            for (int ii = 0; ii < size; ii++) {
                if (queue.size() == 0){
                    System.out.println("test");
                }
               int[] s = queue.poll();

               for (int k = 0; k < move1.length; k++){

                   int n1 = s[0]+move1[k] == -1 ? 9 : (s[0]+move1[k] == 10 ? 0 : s[0]+move1[k]);
                   int n2 = s[1]+move2[k] == -1 ? 9 : (s[1]+move2[k] == 10 ? 0 : s[1]+move2[k]);
                   int n3 = s[2]+move3[k] == -1 ? 9 : (s[2]+move3[k] == 10 ? 0 : s[2]+move3[k]);
                   int n4 = s[3]+move4[k] == -1 ? 9 : (s[3]+move4[k] == 10 ? 0 : s[3]+move4[k]);
                   StringBuilder sb = new StringBuilder();
                   sb.append(n1).append(n2).append(n3).append(n4);
                   if (sb.toString().equals(target)){
                       return step;
                   }
                   if (!tag[n1][n2][n3][n4]){
                       queue.add(new int[]{n1,n2,n3,n4});
                       tag[n1][n2][n3][n4] = true;
                   }
               }


            }
        }
        return -1;
    }
```







## 深度优先搜索DFS

**概念**

> 深度优先搜索（DFS Depth First Search），就是对每一个可能的分支路径深入到不能深入为止，并且每一个节点只能走一步。

总结来说就是**对每一个未访问过的且符合条件的节点**进行深度优先搜索，即将**与该节点有关联的所有节点**都将被**寻找标识**

DFS求解方法

- 递归：递归思想就是把一个事拆分成若干见相同的小事共同组合完成
- 栈：求解最长路径可使用栈作辅助工具



### 695 岛屿最大面积

[LeetCode695 【岛屿最大面积】](https://leetcode-cn.com/problems/max-area-of-island/) *Medium*

**解题思路：**

使用深度优先搜索寻找相连的岛屿区域并求面积，所有岛屿面积取最大值

```java
    public static int maxAreaOfIsland2(int[][] grid) {

        int maxLen = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                maxLen = Math.max(maxLen,dfs(grid,i,j));
            }
        }
        return maxLen;
    }

    public static int dfs(int[][] grid,int i,int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int[] pointX = new int[]{-1,1,0,0};
        int[] pointY = new int[]{0,0,-1,1};
        int ans = 1;
        for (int index = 0; index < 4; index++){
            int x = i+pointX[index];
            int y = j+pointY[index];
            ans += dfs(grid,x,y);
        }
        return ans;
    }
```



### 200 岛屿数量

[LeetCode200 【岛屿数量】](https://leetcode-cn.com/problems/number-of-islands/) *Medium*

**解题思路：**

对于二维数组每一个值为1的元素都进行深度优先搜索，将相关联的值都赋值为0.统计次数

```java
    public static int numIslands(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length;i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int i,int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        int[] pointx = new int[]{-1,1,0,0};
        int[] pointy = new int[]{0,0,1,-1};
        for (int index = 0; index < 4; index++){
            dfs(grid,i+pointx[index],j+pointy[index]);
        }
     }
```





### 547 朋友圈

[LeetCode547 【朋友圈】](https://leetcode-cn.com/problems/friend-circles/) *Medium*

**解题思路：**

给定的矩阵可以看成图的<a href="#邻接矩阵">邻接矩阵</a> ，图的顶点编号表示矩阵M的下标。顶点i和j有且仅有一条边当且仅当M\[i\]\[j]=1时。使用boolean[M.length] visited标识顶点是否走过。

```java
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
```



## 并查集

**概念**

​	









# 数据结构

## 二叉搜索树

**概念**：

二叉搜索树（Binary Search Tree）又称二叉查找树、二叉排序树(BST)。它要么是一个空树，要么它就具备一下特性：

1、若左子树不为空，那么左子树所有节点的值均小于根节点的值

2、若右子树不为空，那么右子树所有节点的值均大于根节点的值

**性质：**

设x是二叉搜索树的一个节点,如果y是x左子树的一个节点，那么y.value <= x.value.如果y是x的右子树的一个节点，那么y.value >= x.vlaue;

在二叉搜索树中，

- 若任意节点的左子树不为空，那么左子树上所有的节点的值均不大于该根节点的值
- 若任意节点的右子树不为空，那么右子树上所有节点的值均不小于该根节点的值
- 任意节点的左右子树也成为二叉搜索树

**时间复杂度**

对于删除、增加、查找的时间负责度都跟树的高度成正比，如果总共有元素n,那么时间复杂度为O(logn)

## 链表

> 链表是一种**物理存储单元上**非连续、非顺序的存储结构，由各个节点组成，**数据元素的逻辑**由各个节点的指针指向次序实现

**LinkedList源码实现细节**

**继承实现**

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
```

**类成员**

```java
		//容量
		transient int size = 0;
    /**
     * Pointer to first node.
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;
```

**节点Node类**

```java
private static class Node<E> {
  E item;
  Node<E> next;
  Node<E> prev;

  Node(Node<E> prev, E element, Node<E> next) {
    this.item = element;
    this.next = next;
    this.prev = prev;
  }
}
```

**常用方法**

- Add(E e)  //在链表末尾插入元素

```java
    /**
     * Links e as last element.
     */
    void linkLast(E e) {
        //保留链表最后一个节点
        final Node<E> l = last;
        //根据新增的元素构造新节点 prev为l,value为e,next为null
        final Node<E> newNode = new Node<>(l, e, null);
       //更新last最后节点为该节点
        last = newNode;
        // 最后节点l为空，则表示此时链表无数据
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
```

- Add(int index,E element) //在指定位置插入元素

```java
public void add(int index, E element) {
  //合法性校验
  checkPositionIndex(index);
  //插入末尾
  if (index == size)
    linkLast(element);
  else
    //插入指定位置
    linkBefore(element, node(index));
}
```

```java
    /**
     * Returns the (non-null) Node at the specified element index.
     * 返回指定元素下标的节点
     */
    Node<E> node(int index) {
        // assert isElementIndex(index);
        // 下标小于size/2,则从first节点开始寻找
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else { //下标大于size/2，则从last节点开始寻找
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
```

```java
    /**
     * Inserts element e before non-null Node succ.
     * 在非空元素succ节点之前插入元素
     */
    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        //记录succ的前节点
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
```

- E get(int index) 返回指定位置的元素

```java
public E get(int index) {
  checkElementIndex(index);
  //详情代码在上，将index和size/2比较判断使用first指针还是last指针
  return node(index).item;
}
```









## 二叉树

- js根据数组创建二叉树

```javascript
/**
构造节点函数
*/
function TreeNode(val){
  //节点值
  this.val = val;
  //左子树
  this.left = null;
  //右子树
  this.right = null;
}


    /**
     * 根据数组生成二叉树
     * 规则： 若当前节点为下标n的元素，则它的左节点为下标2*n+1元素，右节点为2*n+2元素。上下节点相差2倍
     * @param arr 给定数组
     * @param index 数组下标
     * @param len 数组长度
     * @return
     */
function createBinaryTree(arr,index,len){
  if (arr.length === 0){
    return null;
  }
  var node = null;
  //当前数组下标小于数组长度并且当前下标的值不为null时
  if (index < len && arr[index] != null){
      //将当前坐标的元素构建一个节点
      node = new TreeNode(arr[index]);
      //当前节点的左子树元素集合为[2*n+1,len)
      node.left = createBinaryTree(arr,index*2+1,len);
     //当前节点的右子树元素集合为[2*n+2,len)
      node.right = createBinaryTree(arr,index*2+2,len);
  }
  return node;
}

var arr = [3,9,20,null,null,15,7];
var root = createBinaryTree(arr,0,arr.length);
console.log(root);
```



## 邻接矩阵

**概念**

对于图来说，顶点之间会有连通关系，如果使用二维数组存放顶点间的关系·，则该二维数组称为邻接矩阵。

在该矩阵中，每个行和列均表示顶点。存储在行M,列N交叉节点的值V即M\[m\]\[n]表示是否存在顶点M到顶点N的边。 V表示顶点M到顶点N的权重。

 邻接矩阵又分为**有向图邻接矩阵**和**无向图邻接矩阵**。对于无向图邻接矩阵，它一定是对称的。


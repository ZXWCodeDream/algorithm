package main.java.com.zxw.common;

/**
 * ClassName: Util
 * Description:
 *
 * @author zxw
 * @date 2021/3/19 10:28 上午
 * @since JDK 1.8
 */
public class Util {

    public static void print(Object[] arr){

        for (Object obj : arr){
            System.out.println(obj);
        }
    }

    public static void print(int[] arr){

        for (int obj : arr){
            System.out.println(obj);
        }
    }

    public static void swap(Object[] arr,int i,int j){

        Object swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void swap(int[] arr,int i,int j){

        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void swap(Object a,Object b){

        Object swap = a;
        b = a;
        a = swap;
    }
}

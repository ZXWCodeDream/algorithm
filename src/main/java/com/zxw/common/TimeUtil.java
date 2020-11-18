package main.java.com.zxw.common;

/**
 * ClassName: TimeUtil
 * Description:
 *
 * @author zxw
 * @date 2020/6/19 5:41 下午
 * @since JDK 1.8
 */
public class TimeUtil {

    public static void t(long start,long end){
        System.out.println("******    Cost time: "+(end-start)+"ms    ******");
    }

    public static void t(long start){
        long end = System.currentTimeMillis();
        System.out.println("******    Cost time: "+(end-start)+"ms    ******");
    }

    public static void main(String[] args) {

    }
}

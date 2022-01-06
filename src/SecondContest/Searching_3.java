package SecondContest;

import java.util.List;
import java.util.Scanner;

/**
 * @Classname Searching_3
 * @Description TODO
 * @Date 2022/1/6 11:31
 * @Created by XJM
 */
public class Searching_3 {
    public static long getMark(long[] low, long[] len_arr, long x) {
        int left = 0, right = low.length - 1;
        //二分方式寻找x所处的区间
        while (left < right) {
            int mid = (left + right) / 2;
            if (len_arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //x所处区间前的所有区间长度和
        long preLen = left == 0 ? 0 : len_arr[left - 1];
        return low[left] + x - preLen - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int Q = scanner.nextInt();
            long[] low = new long[N]; //记录各区间的左端点
            long[] high = new long[N]; //记录各区间的右端点
            long[] len_arr = new long[N]; //记录各区间的长度
            long[] query = new long[Q];
            long len = 0;
            for (int j = 0; j < N; j++) {
                low[j] = scanner.nextLong();
                high[j] = scanner.nextLong();
                len += high[j] - low[j] + 1;
                len_arr[j] = len;
            }
            for (int j = 0; j < Q; j++) {
                query[j] = scanner.nextLong();
            }
            for (int j = 0; j < Q - 1; j++) {
                System.out.print(getMark(low, len_arr, query[j]) + " ");
            }
            System.out.println(getMark(low, len_arr, query[Q - 1]));
        }
    }
}

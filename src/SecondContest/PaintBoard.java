package SecondContest;

/**
 * @Classname PaintBoard
 * @Description TODO
 * @Date 2022/1/6 16:02
 * @Created by XJM
 */
import java.util.Arrays;
import java.util.Scanner;


public class PaintBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while((--t)>=0){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] boards = new int[n];
            for(int i = 0;i < n;i++){
                boards[i] = sc.nextInt();
            }
            System.out.println(solution(boards,k,n));
        }
    }

    public static int solution(int[] boards, int k, int n){
        if(k>=n){
            Arrays.sort(boards);
            return boards[n-1];
        }

        // 二分的最大值为总和
        int h = boards[0];
        // 二分的最小值是最大值
        int l = boards[0];
        for (int i = 1; i < n; i++) {
            l = Math.max(l, boards[i]);
            h += boards[i];
        }

        while(l<h){
            int bucketSize = l + ((h-l)>>1);
            int bucketCount = getCount(boards, bucketSize);
            if(bucketCount > k){
                l = bucketSize+1;
            }else {
                h = bucketSize;
            }
        }
        return l;
    }

    public static int getCount(int[] boards, int bucketSize){
        int count = 1;
        int current = 0;
        for(int i = 0;i < boards.length;i++){
            current+=boards[i];
            if(current > bucketSize){
                count++;
                current=boards[i];
            }
        }
        return count;
    }
}


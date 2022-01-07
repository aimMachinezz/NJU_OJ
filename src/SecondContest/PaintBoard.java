package SecondContest;

/**
 * @Classname PaintBoard
 * @Description TODO
 * @Date 2022/1/6 16:02
 * @Created by XJM
 */
import java.util.Arrays;
import java.util.Scanner;
/*
    漆狗屋
    Description
    Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An].
    He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.
    The problem is to find the minimum time to get this job done under the constraints that any painter will only paint continuous sections of boards,
    say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
    Constraints:1<=T<=100,1<=k<=30,1<=n<=50,1<=A[i]<=500

    Input
    The first line consists of a single integer T, the number of test cases.
    For each test case, the first line contains an integer k denoting the number of painters and integer n denoting the number of boards.
    Next line contains n- space separated integers denoting the size of boards.

    Output
    For each test case, the output is an integer displaying the minimum time for painting that house.
     */

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


package ThirdContest;

import java.util.Scanner;

/**
 * @Classname IntQuery
 * @Description TODO
 * @Date 2022/1/7 10:06
 * @Created by XJM
 */
/*
* Description

Given an array of positive integers and many queries for divisibility.
In every query Q[i], we are given an integer K , we need to count all elements in the array which are perfectly divisible by K.

Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105


Input

The first line of input contains an integer T denoting the number of test cases.
Then T test cases follow. Each test case consists of three lines.
First line of each test case contains two integers N & M, second line contains N space separated array elements
and third line contains M space separated queries.


Output

For each test case,In new line print the required count for each query Q[i].
* */
public class IntQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int []arr = new int[n];
            int []queries = new int[m];
            for(int i = 0;i < n;i++)
                arr[i] = sc.nextInt();
            for(int i = 0;i < m-1;i++){
                queries[i] = sc.nextInt();
                System.out.print(Query(arr, queries[i])+" ");
            }
            queries[m-1] = sc.nextInt();
            System.out.println(Query(arr, queries[m-1]));
        }
    }

    public static int Query(int []arr, int query){
        int res = 0;
        for(int i = 0;i < arr.length;i++){
            if (arr[i] % query == 0)
                res++;
        }
        return res;
    }
}

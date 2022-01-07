package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.SequenceNumberPower
 * @Description TODO
 * @Date 2021/12/30 10:06
 * @Created by XJM
 */
/*
    序号乘方
    Description
    There are Infinite People Standing in a row, indexed from 1.
    A person having index 'i' has strength of (i*i).You have Strength 'P'.
    You need to tell what is the maximum number of People You can Kill With your Strength P.
    You can only Kill a person with strength 'X' if P >= 'X' and after killing him, Your Strength decreases by 'X'.

    Input
    First line contains an integer 'T' - the number of testcases,
    Each of the next 'T' lines contains an integer 'P'- Your Power.
    Constraints:1<=T<=10000 1<=P<=1000000000000000

    Output
    For each testcase Output The maximum Number of People You can kill.
     */
public class SequenceNumberPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while((--t)>=0){
            long P = sc.nextInt();
            System.out.println(solution(P));
        }
    }

    public static long solution(long p){
        long k = 1;
        while(((k * (k + 1) * (2 * k + 1)) / 6)<=p){
            k++;

        }
        return k-1;
    }
}

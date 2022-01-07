package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.Pow
 * @Description TODO
 * @Date 2021/12/30 14:03
 * @Created by XJM
 */
/*
    数学公式
    Description
    Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C

    Input
    The first line of input consists number of the test cases.
    The following T lines consist of 3 numbers each separated by a space and in the following order:A B C
    'A' being the base number, 'B' the exponent (power to the base number) and 'C' the modular.
    Constraints:1 ≤ T ≤ 70,1 ≤ A ≤ 10^5,1 ≤ B ≤ 10^5,1 ≤ C ≤ 10^5

    Output
    In each separate line print the modular exponent of the given numbers in the test case.
     */

// 由于 (a * b) % c = ((a % c) * (b % c)) % c
// 那么 pow(a, b) % c ==> (a * a * ... * a) % c ==> ((a % c)(a % c)...(a % c)) % c
//                       \______________/          \________________________/
//                            b 个 a                      b 个 a % c
// 快速幂
public class Pow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while((--t)>=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(solution(a,b,c));
        }
    }
    // 由于 (a * b) % c = ((a % c) * (b % c)) % c
    // 那么 pow(a, b) % c ==> (a * a * ... * a) % c ==> ((a % c)(a % c)...(a % c)) % c
    public static long solution(int a, int b,int c){
        /*if(b == 0){
            return 1%c;
        }
        if(b < 0){
            return (solution(1/a,-b,c));
        }
        if(b == 1){
            return a%c;
        }
        if(b%2 == 1){
            return (a%c)*solution((a%c)*(a%c),b/2,c);
        }else {
            return solution((a%c)*(a%c),b/2,c);
        }*/
        int res = 1;
        while (b > 0) {
            if (b % 2 == 1) { //奇数情况下，先乘一个a
                res = ((res % c) * (a % c)) % c;
            }
            a = ((a % c) * (a % c)) % c; //偶数情况，直接平方
            b /= 2;
        }
        return res;
    }
}

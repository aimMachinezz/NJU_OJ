package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.Pow
 * @Description TODO
 * @Date 2021/12/30 14:03
 * @Created by XJM
 */
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

import java.util.Scanner;

/**
 * @Classname SequenceNumberPower
 * @Description TODO
 * @Date 2021/12/30 10:06
 * @Created by XJM
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

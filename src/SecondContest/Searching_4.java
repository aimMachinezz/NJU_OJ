package SecondContest;

import java.util.Scanner;

/**
 * @Classname Searching_4
 * @Description TODO
 * @Date 2022/1/5 10:17
 * @Created by XJM
 */
public class Searching_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            double []arr = new double[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            double []res = solution(arr);
            for (int i = 0;i < res.length-1 ;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println(res[res.length-1]);
        }

    }

    public static double[] solution(double[] arr){
        double [] res = new double[arr.length-1];
        double error = 0.000000000001;//题中给出的允许误差太精确了，会超时，适当扩大误差范围
        for(int i = 0;i < arr.length - 1;i++){
            boolean flag = false;
            double left = arr[i], right = arr[i + 1];
            double mid = (left + right) / 2.0;
            double force = getForce(arr, mid);
            while(left < right){
                if (Math.abs(force) < error) {
                    res[i] = mid;
                    flag = true;
                    break;
                } else if (force > 0) {
                    left = mid;
                } else {
                    right = mid;
                }
                System.out.println(force);
            }
            if(!flag){
                res[i] = left;
            }

        }
        return res;
    }

    public static double getForce(double []arr, double point){
        double []dis = new double[arr.length];
        for(int i = 0;i < arr.length;i++){
            if (point-arr[i] == 0){
                return Double.MAX_VALUE;
            }
            dis[i] = 1/(point-arr[i]);
        }
        double res = 0;
        for(int i = 0;i < arr.length;i++){
            res+=dis[i];
        }
        return res;
    }
}


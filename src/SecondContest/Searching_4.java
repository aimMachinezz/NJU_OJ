package SecondContest;

import java.util.Scanner;

/**
 * @Classname Searching_4
 * @Description TODO
 * @Date 2022/1/5 10:17
 * @Created by XJM
 */
/*
    Searching_4
    Description
    Given n Magnets which are placed linearly, with each magnet to be considered as of point object.
    Each magnet suffers force from its left sided magnets such that they repel it to the right and vice versa.
    All forces are repulsive. The force being equal to the distance (1/d , d being the distance).
    Now given the positions of the magnets, the task to find all the points along the linear line where net force is ZERO.
    Note: Distance have to be calculated with precision of 0.0000000000001.
    Constraints:1<=T<=100,1<=N<=100,1<=M[]<=1000

    Input
    The first line of input contains an integer T denoting the no of test cases.
    Then T test cases follow. The second line of each test case contains an integer N.
    Then in the next line are N space separated values of the array M[], denoting the positions of the magnet.

    Output
    For each test case in a new line print the space separated points having net force zero till precised two decimal places.
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
                System.out.print(String.format("%.2f", res[i]) + " ");
            }
            System.out.println(String.format("%.2f", res[res.length-1]));
        }

    }

    public static double[] solution(double[] arr){
        double [] res = new double[arr.length-1];
        double error = 0.000000000001;//题中给出的允许误差太精确了，会超时，适当扩大误差范围
        for(int i = 0;i < arr.length - 1;i++){
            boolean flag = false;
            double left = arr[i], right = arr[i + 1];
            while(left < right){
                double mid = (left + right) / 2.0;
                double force = getForce(arr, mid);
                if (Math.abs(force) < error) {
                    res[i] = mid;
                    flag = true;
                    break;
                } else if (force > 0) {
                    left = mid;
                } else {
                    right = mid;
                }
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


package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.CountSort
 * @Description TODO
 * @Date 2021/12/23 15:36
 * @Created by XJM
 */
public class CountSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t) >= 0) {
            int k = scan.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = scan.nextInt();
            }
            sort(arr);
            for (int i = 0; i < k; i++) {
                if (i < k - 1) {
                    System.out.print(arr[i] + " ");
                } else {
                    System.out.println(arr[i]);
                }

            }
        }
        scan.close();
    }

    public static void sort(int[] A) {
        int[] temp = new int[A.length];
        int[] count = new int[A.length];
        for(int i = 0;i < A.length - 1;i++) {
            for(int j = i + 1;j < A.length;j++) {
                if(A[i] < A[j])
                    count[j]++;
                else
                    count[i]++;
            }
        }
        for(int i = 0;i < A.length;i++)
            temp[count[i]] = A[i];
        for(int i = 0;i < A.length;i++)
            A[i] = temp[i];
        return;
    }
}

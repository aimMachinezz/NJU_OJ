package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.CountSort
 * @Description TODO
 * @Date 2021/12/23 15:36
 * @Created by XJM
 */
/*
    Description
    实现计数排序，通过多次遍历数组，统计比每一个元素小的其它元素个数，根据该统计量对数据进行排序。

    Input
    输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。

    Output
    输出的每一行为排序结果，用空格隔开，末尾不要空格。
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

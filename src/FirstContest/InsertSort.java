package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.InsertSort
 * @Description TODO
 * @Date 2021/12/23 14:47
 * @Created by XJM
 */
public class InsertSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int k = scan.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = scan.nextInt();
            }
            sort(arr, k);
            for(int i = 0;i < k;i++){
                if(i<k-1){
                    System.out.print(arr[i]+" ");
                }else{
                    System.out.println(arr[i]);
                }

            }
        }
        scan.close();
    }

    public static void sort(int[] arr,int k){
        for (int i = 1;i < k;i++){
            int temp = arr[i];
            int j;
            for (j = i-1;j >=0;j--){
                if(arr[j] > temp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }
}

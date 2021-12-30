package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.BubbleSort
 * @Description TODO
 * @Date 2021/12/23 15:16
 * @Created by XJM
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int k = scan.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = scan.nextInt();
            }
            sort(arr);
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

    public static void sort(int []arr){
        int len = arr.length;
        for(int i = 0;i < len;i++){
            boolean flag = false;
            for(int j =0;j < len-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(flag==false){
                break;
            }
        }
    }
}

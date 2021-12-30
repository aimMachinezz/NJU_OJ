package FirstContest;

import java.util.Scanner;

/**
 * @Classname reverseCount
 * @Description TODO
 * @Date 2021/12/26 15:44
 * @Created by XJM
 */
public class ReverseCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int k = scan.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(count(arr));

        }
        scan.close();
    }

    public static int count(int[] arr){
        int res=0;
        int len = arr.length;
        for(int i = 0;i< len ;i++){
            for(int j = i+1;j < len;j++){
                if(arr[i] > arr[j]){
                    res++;
                }
            }
        }
        return res;
    }
}

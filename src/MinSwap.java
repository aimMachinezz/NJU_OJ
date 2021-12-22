/**
 * @author XJM
 * @title: MinSwap
 * @projectName NJU_OJ
 * @description: TODO
 * @date 2021/12/2216:36
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinSwap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int k = scan.nextInt();
            int[] arr = new int[k];
            System.out.println();
            for (int i = 0; i < k; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(solution(arr));
        }
        scan.close();
    }

    public static int solution(int [] arr){
        int res=0;
        int[] temp = Arrays.copyOf(arr, arr.length);
        //排序并记录每个数的正确位置
        Arrays.sort(temp);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            indexMap.put(temp[i], i);
        }
        boolean[] flags = new boolean[temp.length];
        for(int i=0;i<temp.length;i++){
            while(!flags[i]){
                if(indexMap.get(arr[i])==i){
                    flags[i]=true;
                    continue;
                }else {
                    int x = arr[i];
                    int position = indexMap.get(arr[i]);
                    arr[i] = arr[position];
                    arr[position] = x;
                    res++;
                }
            }
        }
        return res;
    }
}

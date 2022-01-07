package FirstContest; /**
 * @author XJM
 * @title: FirstContest.MinSwap
 * @projectName NJU_OJ
 * @description: TODO
 * @date 2021/12/2216:36
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
    最小交换次数
    Description
    Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.
    Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.

    Input
    The first line of input contains an integer T denoting the no of test cases . Then T test cases follow .
    Each test case contains an integer N denoting the no of element of the array A[ ].
    In the next line are N space separated values of the array A[ ] .(1<=T<=100;1<=N<=100;1<=A[] <=1000)

    Output
    For each test case in a new line output will be an integer denoting minimum umber of swaps that are required to sort the array.
     */

//获取使得数组升序的最小交换次数
public class MinSwap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int k = scan.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.print(solution(arr)+"\n");
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

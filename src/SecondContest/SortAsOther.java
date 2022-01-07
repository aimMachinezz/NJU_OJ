package SecondContest;

import java.util.*;

/**
 * @Classname SortAsOther
 * @Description TODO
 * @Date 2022/1/6 10:29
 * @Created by XJM
 */
/*
    按照另一个数组排序
    Description
    Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those in A2.
    For the elements not present in A2. Append them at last in sorted order.
    It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
    Input:A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8} A2[] = {2, 1, 8, 3}Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
    Since 2 is present first in A2[], all occurrences of 2s should appear first in A[],
    then all occurrences 1s as 1 comes after 2 in A[]. Next all occurrences of 8 and then all occurrences of 3.
    Finally we print all those elements of A1[] that are not present in A2[]
    Constraints:1 ≤ T ≤ 50 1 ≤ M ≤ 50 1 ≤ N ≤ 10 & N ≤ M 1 ≤ A1[i], A2[i] ≤ 1000

    Input
    The first line of input contains an integer T denoting the number of test cases.
    The first line of each test case is M and N. M is the number of elements in A1 and N is the number of elements in A2.
    The second line of each test case contains M elements. The third line of each test case contains N elements.

    Output
    Print the sorted array according order defined by another array.
     */
public class SortAsOther {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int []arr1 = new int[n1];
            int []arr2 = new int[n2];
            for(int i = 0;i < n1;i++){
                arr1[i] = sc.nextInt();
            }
            for(int i = 0;i < n2;i++){
                arr2[i] = sc.nextInt();
            }
            Sort(arr1, arr2);
        }
    }

    public static void Sort(int []arr1, int[] arr2){
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> notInAnother = new ArrayList<>();
        for(int i:arr2)
            count.put(i, 0);
        for(int i:arr1){
            if(count.containsKey(i)){
                count.put(i,count.get(i)+1);
            }else {
                notInAnother.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < count.size();i++){
            for (int j = 0;j < count.get(arr2[i]);j++)
                res.add(arr2[i]);
        }
        Collections.sort(notInAnother);
        res.addAll(notInAnother);
        Print(res);
    }

    public static void Print(List<Integer> res){
        for (int i = 0;i < res.size()-1;i++)
            System.out.print(res.get(i)+" ");
        System.out.println(res.get(res.size()-1));
    }
}

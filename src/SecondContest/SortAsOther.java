package SecondContest;

import java.util.*;

/**
 * @Classname SortAsOther
 * @Description TODO
 * @Date 2022/1/6 10:29
 * @Created by XJM
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

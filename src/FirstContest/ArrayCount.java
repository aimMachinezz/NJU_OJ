package FirstContest;

import java.util.*;

/**
 * @Classname FirstContest.ArrayCount
 * @Description TODO
 * @Date 2021/12/29 9:56
 * @Created by XJM
 */
/*
    按照数值个数排序
    Description
    对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。
    例如，给定数组为{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。

    Input
    输入的第一行为用例个数；后面每一个用例使用两行表示，第一行为数组长度，第二行为数组内容，数组元素间使用空格隔开。

    Output
    每一个用例的排序结果在一行中输出，元素之间使用空格隔开。
     */
public class ArrayCount {
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

            for (int j = 0; j < k - 1; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println(arr[k - 1]);

        }
        scan.close();
    }

    public static void sort(int[] arr){
        if(arr.length==0){
            return;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < arr.length;i++){
            if(map.containsKey(arr[i])){
                int tempValue = map.get(arr[i])+1;
                map.put(arr[i], tempValue);
            }else {
                map.put(arr[i],1);
            }
        }
        List<Map.Entry<Integer, Integer>> res =
                new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(res, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else {
                    if (o1.getKey() < o2.getKey()) {
                        return -1;
                    } else if (o1.getKey() > o2.getKey()) {
                        return 1;
                    }
                }
                return 0;
                }
            });
        int index = 0;
        for(int i = 0;i < res.size();i++){
            for(int j=0;j<res.get(i).getValue();j++){
                arr[index++] = res.get(i).getKey();
            }
        }
    }
}

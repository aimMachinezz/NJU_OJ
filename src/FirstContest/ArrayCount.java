package FirstContest;

import java.util.*;

/**
 * @Classname FirstContest.ArrayCount
 * @Description TODO
 * @Date 2021/12/29 9:56
 * @Created by XJM
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

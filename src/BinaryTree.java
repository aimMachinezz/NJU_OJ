import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname BinaryTree
 * @Description TODO
 * @Date 2021/12/30 10:41
 * @Created by XJM
 */
public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while((--t)>=0){
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            printSolution(solution(arr));
        }
    }

    public static List<int[]> solution(int [] arr){
        double n = arr.length;

        List<int[]> res = new ArrayList<>();
        int i = 1;
        while(Math.pow(2, i)-1 < n){
            i++;
        }
        int index = 0;
        for(int j = 0;j < i-1;j++){
            int[] temp = new int[(int)Math.pow(2,j)];
            for (int k = 0;k < Math.pow(2,j) && index< arr.length;k++){
                temp[k] = arr[index++];
            }
            temp = Clear(temp);
            Arrays.sort(temp);
            res.add(temp);
        }
        int last = arr.length-((int)Math.pow(2, i-1)-1);
        int []temp = new int[last];
        for (int k = 0;k < temp.length;k++){
            temp[k] = arr[index++];
        }
        temp = Clear(temp);
        Arrays.sort(temp);
        res.add(temp);
        return res;
    }

    public static void printSolution(List<int[]> res){
        for(int i = 0;i < res.size();i++){
            for(int j = 0;j < res.get(i).length-1;j++)
                System.out.print(res.get(i)[j]+" ");
            System.out.println(res.get(i)[res.get(i).length-1]);
        }
    }
    //去重
    public static int[] Clear(int[] arr){
        List<Integer> list = new ArrayList<>();

        for(int i = 0;i < arr.length; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        int []res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}

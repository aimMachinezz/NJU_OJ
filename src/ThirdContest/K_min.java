package ThirdContest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname K_min
 * @Description TODO
 * @Date 2022/1/9 8:47
 * @Created by XJM
 */
/*
    区间第k最小
    Description
    找到给定数组的给定区间内的第K小的数值。

    Input
    输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个数用空格隔开；第二行是区间（第几个数到第几个数，两头均包含），两个值用空格隔开；第三行为K值。

    Output
    结果。
     */
public class K_min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String []str = sc.nextLine().split(" ");
            int []arr = new int[str.length];
            for(int i = 0;i < str.length;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            String []sectionStr = sc.nextLine().split(" ");
            int []section = new int[sectionStr.length];
            section[0] = Integer.parseInt(sectionStr[0]);
            section[1] = Integer.parseInt(sectionStr[1]);
            int k = Integer.parseInt(sc.nextLine());
            System.out.println(solution(arr, section, k));
        }
    }

    public static int solution(int []arr, int []section, int k){
        int res = 0;
        int len = section[1] - section[0] + 1;
        int []temp = new int[len];
        for(int i =0;i < len;i++)
            temp[i] = arr[section[0]+i-1];
        Arrays.sort(temp);
        res = temp[k-1];
        return res;
    }
}

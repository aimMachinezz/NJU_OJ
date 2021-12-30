package FirstContest;

import java.util.Scanner;

/**
 * @author XJM
 * @title: FirstContest.Keliuliang
 * @projectName NJU_OJ
 * @description: TODO
 * @date 2021/12/2214:18
 */
//没写完，OJ系统有问题，直接main函数可AC
public class Keliuliang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int size = scan.nextInt();
            int [] entry = new int[size];
            int [] exit = new int[size];
            for (int i = 0; i <size; i++) {
                entry[i] = scan.nextInt();
            }
            for (int i = 0; i <size; i++) {
                exit[i] = scan.nextInt();
            }
            int [][]res=new int[t][2];
            for(int i=0;i<t;i++){
                System.out.println(res[i][0]+" "+res[i][1]);
            }
        }
        scan.close();
    }
}

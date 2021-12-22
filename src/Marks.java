/**
 * @author XJM
 * @title: Marks
 * @projectName NJU_OJ
 * @description: TODO
 * @date 2021/12/2214:18
 */
import java.util.*;
import java.util.Scanner;
public class Marks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int stuCount = scan.nextInt();
            int [][] mark = new int[stuCount][3];
            for (int i = 0; i <stuCount; i++) {
                for(int j=0;j<3;j++){
                    mark[i][j]=scan.nextInt();
                }
            }
            int [][] res = solution(stuCount, mark);
            for(int i=0;i<stuCount;i++){
                System.out.println(res[i][0]+" "+res[i][1]+" "+res[i][2]);
            }
        }
        scan.close();
    }

    public static int[][] solution(int stuCount, int [][]mark){
        for(int i = 0 ;i<stuCount-1;i++){
            //第i趟比较
            for(int j = 0 ;j<stuCount-i-1;j++){
                //开始进行比较，如果mark[j]比mark[j+1]的值大，那就交换位置
                if(mark[j][0]>mark[j+1][0]){
                    swap(mark[j],mark[j+1]);
                }
                if(mark[j][0]==mark[j+1][0]){
                    if(mark[j][1] < mark[j+1][1]){
                        swap(mark[j],mark[j+1]);
                    }
                    if(mark[j][1]==mark[j+1][1]){
                        if(mark[j][2]>mark[j+1][2]){
                            swap(mark[j],mark[j+1]);
                        }
                    }
                }
            }

        }
        return mark;
    }

    public static void swap(int[]mark1, int []mark2){
        for(int i=0;i<3;i++){
            int temp=mark1[i];
            mark1[i]=mark2[i];
            mark2[i]=temp;
        }
    }
}

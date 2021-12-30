package SecondContest;

import java.util.Scanner;

/**
 * @Classname BFS
 * @Description TODO
 * @Date 2021/12/30 16:33
 * @Created by XJM
 */
public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String []para = sc.nextLine().split(" ");
            int n = Integer.parseInt(para[0]);
            char start = para[1].charAt(0);
            String []vertex = sc.nextLine().split(" ");
            int [][]graph = new int[n][n];
            for(int i = 0;i < n;i++){
                String []temp = sc.nextLine().split(" ");
                for(int j = 1;j < temp.length;j++){
                    graph[i][j-1] = Integer.parseInt(temp[j]);
                }
            }
        }
    }

    public static void bfs(int[][] graph, String vertex){

    }
}

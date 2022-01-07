package SecondContest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Classname BFS
 * @Description TODO
 * @Date 2021/12/30 16:33
 * @Created by XJM
 */
/*
    广度优先遍历图
    Description
    按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。

    Input
    输入第一行为测试用例个数，后面每一个用例用多行表示，用例第一行是节点个数n和开始顶点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。
    值之间使用空格隔开。

    Output
    输出遍历顺序，用空格隔开
     */
public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String []para = sc.nextLine().split(" ");
            int n = Integer.parseInt(para[0]);
            String start = para[1];
            String []vertex = sc.nextLine().split(" ");
            int [][]graph = new int[n][n];
            for(int i = 0;i < n;i++){
                String []temp = sc.nextLine().split(" ");
                for(int j = 1;j < temp.length;j++){
                    graph[i][j-1] = Integer.parseInt(temp[j]);
                }
            }
            bfs(graph,start);
            System.out.println("");
        }
    }

    public static void bfs(int[][] graph, String start){
        boolean []isVisited = new boolean[graph.length];
        int index = start.charAt(0)-'a';
        Queue<Integer> queue = new LinkedList<Integer>();
        isVisited[index] = true;
        System.out.print(start.charAt(0)+" ");
        queue.offer(index);
        while (!queue.isEmpty()){
            int crr = queue.poll();
            for(int i = 0;i < graph.length;i++){
                if(graph[crr][i]==1 && !isVisited[i]){
                    isVisited[i] = true;
                    char res = (char) ('a'+i);
                    System.out.print(res+" ");
                    queue.offer(i);
                }
            }
        }
    }
}

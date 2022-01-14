package SecondContest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname DFS
 * @Description TODO
 * @Date 2021/12/31 11:17
 * @Created by XJM
 */
/*
    深度优先遍历
    Description
    按照给定的起始顶点深度优先遍历给定的无向图，尝试所有可能的遍历方式，打印遍历过程中出现的最大深度。
    Input
    输入第一行是用例个数，后面每个用例使用多行表示，用例的第一行是图中节点的个数n和起始点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。
    值之间使用空格隔开。
    Output
    输出深度优先遍历中遇到的最大深度。
     */
public class DFS {
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
            boolean []isVisited = new boolean[n];
            List<List<Integer>> res = new ArrayList<>();
            int max = 0;
            for(int i = 0;i < n;i++){
                if(!isVisited[i]){
                    List<Integer> resTemp = new ArrayList<>();
                    dfs(graph, start, isVisited ,resTemp);
                    res.add(resTemp);
                }
            }
            for (int i =0;i < res.size();i++){
                max = Math.max(res.get(i).size(), max);
            }
            System.out.println(max);
        }
    }

    public static void dfs(int[][] graph, String start, boolean[] isVisited, List<Integer> res){
        int index = start.charAt(0)-'a';
        isVisited[index] = true;
        res.add(index);
        for(int i =0 ;i < graph.length;i++){
            if(graph[index][i]==1 && !isVisited[i]){
                char next = (char) ('a'+i);
                dfs(graph,String.valueOf(next),isVisited,res);
            }
        }
    }
}
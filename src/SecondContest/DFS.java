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

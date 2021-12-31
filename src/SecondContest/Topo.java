package SecondContest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Classname Topo
 * @Description TODO
 * @Date 2021/12/30 15:37
 * @Created by XJM
 */

import java.util.*;

public class Topo {
    /*
    拓扑排序解的个数
    Description
    给定有向无环图中所有边，计算图的拓扑排序解的个数。

    Input
    输入第一行为用例个数，后面每一行表示一个图中的所有边，边的起点和终点用空格隔开，边之间使用逗号隔开。

    Output
    输出拓扑排序解的个数。
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int t = Integer.parseInt(scanner.nextLine());
            while(t-->0) {
                String[] edges = scanner.nextLine().split(",");
                Set<String> vertex = new HashSet<>();
                String[] v1 = edges[0].split(" ");
                vertex.add(v1[1]);
                vertex.add(v1[2]);
                for (int j = 1;j < edges.length;j++) {
                    String[] v = edges[j].split(" ");
                    vertex.add(v[0]);
                    vertex.add(v[1]);

                }

                int n = vertex.size();

                //邻接矩阵
                int[][] graph = new int[n][n];
                //记录所有顶点的入度
                int[] inDegree = new int[n];
                int x1 = v1[1].charAt(0) - 'a';
                int y1 = v1[2].charAt(0) - 'a';
                graph[x1][y1] = 1;
                inDegree[y1]++;
                for (int j = 1;j < edges.length;j++) {
                    String[] v = edges[j].split(" ");
                    int x = v[0].charAt(0) - 'a';
                    int y = v[1].charAt(0) - 'a';

                    graph[x][y] = 1;
                    inDegree[y]++;
                }

                //记录入度为0的点
                List<Integer> zeros = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (inDegree[j] == 0) {
                        zeros.add(j);
                    }
                }
                //标志节点是否访问，即是否已加入拓扑队列中
                boolean[] isVisited = new boolean[n];
                //存放所有拓扑排序结果
                List<List<Integer>> res = new ArrayList<>();
                topo(graph, inDegree, zeros, isVisited, new ArrayList<Integer>(), res);
                System.out.print(res.size()+"\n");
            }

    }
    /**
     *
     * @param graph 邻接矩阵
     * @param inDegree 入度数组
     * @param zeros 入度为0的节点列表
     * @param isVisited 标志节点是否已访问
     * @param list 记录当前拓扑
     * @param res 所有拓扑的列表
     */
    public static void topo(int[][] graph, int[] inDegree, List<Integer> zeros, boolean[] isVisited, ArrayList<Integer> list, List<List<Integer>> res) {
        //所有点都已访问
        if (list.size() >= graph.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < zeros.size(); i++) {
            int index = zeros.get(i);

            if(isVisited[index] == false){
                //将顶点插入拓扑排序中
                list.add(index);
                isVisited[index] = true;
                //记录删去的边的终点
                List<Integer> deletedEdge = new ArrayList<>();
                //记录新的入度为0的顶点个数
                int cnt = 0;
                //将index顶点出发的边删除
                for (int j = 0; j < graph.length; j++) {
                    if (graph[index][j] == 1) {
                        deletedEdge.add(j);
                        inDegree[j]--;
                        graph[index][j] = 0;
                        if (inDegree[j] == 0) {
                            zeros.add(j);
                            cnt++;
                        }
                    }
                }
                topo(graph, inDegree, zeros, isVisited, list, res);
                //将删除的边恢复，将点的访问状态重置
                isVisited[index] = false;
                list.remove(list.size() - 1);
                for (int j = 0; j < cnt; j++) {
                    zeros.remove(zeros.size() - 1);
                }
                for (int j=0;j<deletedEdge.size();j++) {
                    graph[index][deletedEdge.get(j)] = 1;
                    inDegree[deletedEdge.get(j)]++;
                }
            }
            }


    }
}


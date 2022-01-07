package FirstContest; /**
 * @author XJM
 * @title: mergeArray
 * @projectName NJU_OJ
 * @description: TODO
 * @date 2021/12/2215:06
 */
import java.util.*;
/*
    合并数组
    Description
    Given K sorted arrays arranged in a form of a matrix, your task is to merge them.
    You need to complete mergeKArrays function which takes 2 arguments,
    an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the no. of sorted arrays.
    The function should return a pointer to the merged sorted arrays.
    There are multiple test cases. For each test case, this method will be called individually.

    Input
    The first line of input will denote the no of Test cases then T test cases will follow .
    Each test cases will contain an integer N denoting the no of sorted arrays.
    Then in the next line contains all the elements of the array separated by space.（1<=T<=50；1<=N<=10）

    Output
    The output will be the sorted merged array.
     */

//分治法解决，将n个数组不断划分，两两合并
public class MergeArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int k = scan.nextInt();
            int[][] arr = new int[k][k];
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    arr[j][l] = scan.nextInt();
                }
            }
            problem(arr);
        }
        scan.close();
    }
    static void problem(int[][] arr) {
        int[] ans = solution(arr);
        print(ans);
    }

    static int[] solution(int[][] arr) {
        return getMergeArr(arr, 0, arr.length - 1);
    }

    static int[] getMergeArr(int[][] arr, int l, int h) {
        if (l == h) {
            return arr[l];
        }
        int mid = l + ((h - l) >> 1);
        int[] left = getMergeArr(arr, l, mid);
        int[] right = getMergeArr(arr, mid + 1, h);
        return merge(left, right);
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int index = nums1.length + nums2.length - 1;
        int[] ans = new int[nums1.length + nums2.length];
        while (i >= 0 && j >= 0) {
            ans[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            ans[index--] = nums1[i--];
        }
        while (j >= 0) {
            ans[index--] = nums2[j--];
        }
        return ans;
    }

    private static void print(int[] arr) {
        StringBuilder sb = getStringBuilder(arr);
        System.out.print(sb.toString()+"\n");
    }

    private static StringBuilder getStringBuilder(int[] arr) {
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            if (i != n - 1) {
                sb.append(" ");
            }
        }
        return sb;
    }


}

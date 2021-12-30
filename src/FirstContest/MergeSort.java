package FirstContest;

import java.util.Scanner;

/**
 * @Classname FirstContest.MergeSort
 * @Description TODO
 * @Date 2021/12/26 15:38
 * @Created by XJM
 */
public class MergeSort {
    public static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int l = left; l < right + 1; l++) {
            nums[l] = temp[l - left];
        }
    }

    //非递归归并排序
    public static void mergeSort(int[] nums) {
        int k = 1;
        int len = nums.length;
        while (k < len) {
            int i = 0;
            while (i <= len - 2 * k) {
                merge(nums, i, i + k - 1, i + 2 * k - 1); //两两合并
                i += 2 * k;
            }
            if (i <= len - k) {
                merge(nums, i, i + k - 1, len - 1);  //余下不足2k的长度也需要进行合并处理
            }
            k <<= 1;  //每次处理的子序列长度成倍扩展
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            mergeSort(nums);
            for (int i = 0; i < N - 1; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println(nums[N - 1]);
        }
    }
}

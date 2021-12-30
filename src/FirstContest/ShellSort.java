package FirstContest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname FirstContest.ShellSort
 * @Description TODO
 * @Date 2021/12/26 16:05
 * @Created by XJM
 */
public class ShellSort {
    public static void shellSort(int[] nums, int[] gaps) {
        for (int i = 0; i < gaps.length; i++) {
            int temp, index;
            for (int j = gaps[i]; j < nums.length; j++) {
                temp = nums[j];
                //插入排序
                for (index = j - gaps[i]; index >= 0; index -= gaps[i]) {
                    if (nums[index] > temp) {
                        nums[index + gaps[i]] = nums[index];
                    } else {
                        break;
                    }
                }
                nums[index + gaps[i]] = temp;
            }
        }
    }

    public static int[] toIntArray(String[] strs) {
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String[] num_str = scanner.nextLine().split(" ");
            String[] gap_str = scanner.nextLine().split(" ");
            int[] nums = toIntArray(num_str);
            int[] gaps = toIntArray(gap_str);
            shellSort(nums, gaps);
            for (int j = 0; j < nums.length - 1; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println(nums[nums.length - 1]);
        }
    }
}

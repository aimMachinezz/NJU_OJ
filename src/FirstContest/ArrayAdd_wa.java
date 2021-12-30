package FirstContest;
/**
 * @author XJM
 * @title: arrayAdd
 * @projectName NJU_OJ
 * @description: TODO
 * @date 2021/12/2214:23
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayAdd_wa {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int size = scan.nextInt();
            int k = scan.nextInt();

            int [] entry = new int[size];
            for (int i = 0; i <size; i++) {
                entry[i] = scan.nextInt();
            }
            List<List<Integer>> res = fourSum(entry, k);
            print(res);
        }
        scan.close();
    }

    public static List<List<Integer>> fourSum(int[] nums,int k) {
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<4){
            return ans;
        }
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 枚举 b
            //初始化d=n-1
            int four = n-1;
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //枚举 c
                for(int third = second+1;third<n;++third){
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    while (third < four && nums[first] + nums[second] + nums[third] +nums[four]> k) {
                        --four;
                    }
                    // 如果指针重合，随着 c 后续的增加
                    // 就不会有满足 a+b+c+d=0 并且 c<d 的 d 了，可以退出循环
                    if (third == four) {
                        break;
                    }
                    if (nums[first] + nums[second] + nums[third] +nums[four] == k) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[four]);
                        ans.add(list);
                    }
                }

            }
        }
        return ans;
    }

    private static void print(List<List<Integer>> res) {
        for (List<Integer> subArr : res) {
            for (Integer element : subArr) {
                System.out.print(element + " ");
            }
            System.out.print("$");
        }
        System.out.print("\n");
    }
}

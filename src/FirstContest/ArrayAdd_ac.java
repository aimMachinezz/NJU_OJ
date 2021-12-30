package FirstContest; /**
 * @author XJM
 * @title: test
 * @projectName NJU_OJ
 * @description: TODO
 * @date 2021/12/2221:27
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayAdd_ac {
    private static int NUM_AMOUT = 4;

    //四数之和，求出所有和为target的包含四个元素的子数组
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        //如果数组长度不足4，则返回空结果
        if (nums == null || nums.length < NUM_AMOUT) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - NUM_AMOUT + 1; i++) {
            //对于重复值，不需要再次计算，最终结果不重复
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            //数组升序排序后，当连续四个元素和超过target时，后续不再可能出现和为target的子数组，跳出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }

            //如果当前元素与最大的三个元素相加结果小于target，也不可能出现包含该元素的最终结果，跳过此次计算
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target){
                continue;
            }

            //将四数之和问题转化为三数之和
            for (int j = i + 1; j < len - NUM_AMOUT + 2; j++) {

                //与四数之和问题相同的处理方式
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break;
                }

                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target){
                    continue;
                }

                //将三数之和问题转化为两数之和，用二分法解决
                int l = j + 1, r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];

                    //和为target，则将四数加入结果集中
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        //跳过重复值，继续寻找下一个解
                        while (l < r && nums[l] == nums[l + 1]){
                            l++;
                        }
                        l++;
                        while (l < r && nums[r] == nums[r - 1]){
                            r--;
                        }
                        r--;
                    } else if (sum > target) {
                        //和大于target，则将right指针左移
                        r--;
                    } else {
                        //和小于target，则将left指针右移
                        l++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while ((--t)>=0) {

                int n = scanner.nextInt();
                int target = scanner.nextInt();
                int[] nums = new int[n];
                for (int j = 0; j < n; j++) {
                    nums[j] = scanner.nextInt();
                }
                List<List<Integer>> res = fourSum(nums, target);
                print(res);
        }
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

import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname QuickSort_feidigui
 * @Description TODO
 * @Date 2021/12/23 16:42
 * @Created by XJM
 */
public class QuickSort_feidigui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            quickSort(nums);
            for (int i = 0; i < N - 1; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println(nums[N - 1]);
        }
    }


    //非递归快排，使用栈
    public static void quickSort(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(nums.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();  //数组右端位置后入先出
            int left = stack.pop();
            if (left >= right) continue;
            int index = partition(nums, left, right);
            stack.push(left);
            stack.push(index - 1);
            stack.push(index + 1);
            stack.push(right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        //以开始位置元素为基准，将比其小的置于左边，大的置于右边
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= base) {
                left++;
            }
            nums[right] = nums[left];
        }
        //此时，left == right，这个坑位就是之前的基准元素
        nums[left] = base;
        return left;
    }
}

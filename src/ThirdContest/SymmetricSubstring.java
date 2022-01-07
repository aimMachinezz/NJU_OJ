package ThirdContest;

import java.util.Scanner;

/**
 * @Classname SymmetricSubstring
 * @Description TODO
 * @Date 2022/1/7 10:18
 * @Created by XJM
 */
/*
    对称子字符串
    Description
    Given a string ‘str’ of digits, find length of the longest substring of ‘str’,
    such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.

    Input
    输入第一行是测试用例的个数，后面每一行表示一个数字组成的字符串，例如："123123"

    Output
    输出找到的满足要求的最长子串的长度。例如，给定的例子长度应该是 6。每行对应一个用例的结果。
     */
public class SymmetricSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String str = sc.nextLine();
            solution(str);
        }
    }

    public static void solution(String str){
        int []nums = new int[str.length()];
        for (int i = 0;i < str.length();i++){
            nums[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            int leftSum = 0, rightSum = 0;
            int left = i, right = i + 1;
            //两边扩散
            while (left >= 0 && right < str.length()) {
                leftSum += nums[left];
                rightSum += nums[right];
                if (leftSum == rightSum) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                left--;
                right++;
            }
        }
        System.out.println(maxLen);
    }
}

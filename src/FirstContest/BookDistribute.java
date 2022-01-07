package FirstContest;

import java.util.Arrays;
import java.util.Scanner;
/*
    书本分发
    Description
    You are given N number of books. Every ith book has Pi number of pages. You have to allocate books to M number of students.
    There can be many ways or permutations to do so.
    In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations,
    the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations,
    and print this minimum value. Each book will be allocated to exactly one student.
    Each student has to be allocated at least one book.
    每一个学生只能分配连续出现的书本。

    Input
    The first line contains 'T' denoting the number of testcases.
    Then follows description of T testcases:
    Each case begins with a single positive integer N denoting the number of books.
    The second line contains N space separated positive integers denoting the pages of each book.
    And the third line contains another integer M, denoting the number of students
    Constraints:1<= T <=70，1<= N <=50，1<= A [ i ] <=250，1<= M <=50，
    Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding)

    Output
    For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.
     */
public class BookDistribute {

    private static int NOT_FOUND_NUM = -1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int t = scan.nextInt();

            for (int caseCount = 0; caseCount < t; caseCount++) {
                int bookCount = scan.nextInt();
                int[] pages = new int[bookCount];
                for (int i = 0; i < bookCount; i++) {
                    pages[i] = scan.nextInt();
                }
                int studentCount = scan.nextInt();
                int res = solution(bookCount, pages, studentCount);
                System.out.println(res);
            }
        }
    }

    private static int solution(int bookCount, int[] pages, int studentCount) {

        if (studentCount > bookCount) {
            return NOT_FOUND_NUM;
        }

        // 二分的最大值为所有页数的总和
        int h = pages[0];
        // 二分的最小值是书本页数的最大值
        int l = pages[0];
        for (int i = 1; i < bookCount; i++) {
            l = Math.max(l, pages[i]);
            h += pages[i];
        }

        while (l < h) {
            int bucketSize = l + ((h - l) >> 1);
            int bucketCount = getBucketCount(pages, bucketSize);
            if (bucketCount > studentCount) {
                l = bucketSize + 1;
            } else {
                h = bucketSize;
            }
        }

        return l;
    }

    private static int getBucketCount(int[] pages, int bucketSize) {
        int bucketCount = 1;

        int crrSize = 0;

        for (int i = 0; i < pages.length; i++) {
            crrSize += pages[i];
            //System.out.println("crrsize:"+crrSize);
            if (crrSize > bucketSize) {
                crrSize = pages[i];

                ++bucketCount;
                //System.out.println(bucketSize+" "+crrSize+" "+bucketCount);
            }
        }
        return bucketCount;
    }
}



import java.util.Arrays;
import java.util.Scanner;

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
            System.out.println("crrsize:"+crrSize);
            if (crrSize > bucketSize) {
                crrSize = pages[i];

                ++bucketCount;
                System.out.println(bucketSize+" "+crrSize+" "+bucketCount);
            }
        }
        return bucketCount;
    }
}



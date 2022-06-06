package mogacko.week4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Week4_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        sc.nextLine();
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(n, s, arr, 0);
    }

    private static int count = 0;
    private static void bt(int n, int s, int[] arr, long start) {
        if (n == start) {
            return;
        }

        int sum = Arrays.stream(arr).skip(start).sum();
        if (sum == s) {
            count++;
        }

        bt(n, s, arr, start + 1);

    }


}

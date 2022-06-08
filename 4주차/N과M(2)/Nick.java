package mogacko.week4;

import java.util.Scanner;

public class Nick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] carrier = new int[m];

        bt(n, m, 1, 0, carrier);

    }

    private static void bt(int n, int m, int start, int depth, int[] carrier) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : carrier) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        int nowLength = n - start + 1;
        if (nowLength <= 0) return;
        for (int i = start; i <= n; i++) {
            carrier[depth] = i;
            bt(n, m, i + 1, depth + 1, carrier);
        }
    }

}

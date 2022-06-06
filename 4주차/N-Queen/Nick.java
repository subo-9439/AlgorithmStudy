package mogacko.week4;

import java.util.Scanner;

public class Week4_1 {

    private static int count = 0;
    private static int n = 0;
    private static int[] position;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        position = new int[n];

        bt(0);

        System.out.println(count);
    }

    private static void bt(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        // 위치 비교하여, 놓을 수 있으면 계속 진행 / 놓을 수 없으면 다음 위치
        for (int i = 0; i < n; i++) {
            position[depth] = i;

            if (isValidPosition(depth)) {
                bt(depth + 1);
            }
        }
    }

    // 이전 퀸의 경로에 현재 퀸을 놓으려는 자리가 겹치면, 불가능.
    private static boolean isValidPosition(int depth) {
        for (int previous = 0; previous < depth; previous++) { // previous: 이전 depth
            if (position[previous] == position[depth]) {
                return false;
            }
            else if ((previous + position[previous]) == (depth + position[depth])) {
                return false;
            }
            else if ((previous - position[previous]) == (depth - position[depth])) {
                return false;
            }
        }
        return true;
    }

}
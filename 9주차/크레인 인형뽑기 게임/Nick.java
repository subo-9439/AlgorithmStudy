package mogacko.week9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Week9_1 {

    public  int solution(int[][] board, int[] moves) {
        // board[][]를 Queue[]로 변환
        // moves 하나씩 pop()
        // poll() 한 요소와 바구니stack의 peek()와 비교하여 적절히 처리(pop()&카운트 or push())

        Queue<Integer>[] boards = new LinkedList[board.length];
        Arrays.setAll(boards, i -> new LinkedList<>());

        for (int i = 0; i < board.length; i++) { // board[][]를 Queue[]로 변환
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    boards[j].add(board[i][j]);
                }
            }
        }

        int count = 0;
        Stack<Integer> haystack = new Stack<>();
        for (int move : moves) {
            if (boards[move - 1].isEmpty()) continue;

            Integer item = boards[move - 1].poll(); // moves 하나씩 pop()

            // pop() 한 요소와 바구니stack의 peek()와 비교하여 적절히 처리(pop()&카운트 or push)
            if (!haystack.isEmpty() && haystack.peek() == item) {
                haystack.pop();
                count += 2;
                continue;
            }

            haystack.push(item);
        }

        return count;
    }

}

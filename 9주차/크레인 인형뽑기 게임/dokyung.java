import java.util.Stack;

class Solution {
        public int solution(int[][] board, int[] moves) {
                int answer = 0;
                // 인형 담는 stack
                Stack<Integer> stack = new Stack<>();

                //크레인 이동 횟수
                for (int i = 0; i < moves.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                                if (board[j][moves[i] - 1] != 0) {
                                        if (!stack.empty() && stack.peek() == board[j][moves[i] - 1]) {
                                                answer++;
                                                stack.pop();
                                                board[j][moves[i] - 1] = 0;
                                                break;
                                        } else {
                                                stack.push(board[j][moves[i] - 1]);
                                                board[j][moves[i] - 1] = 0;
                                                break;
                                        }
                                }
                        }
                }
                // 2개씩 없어지므로
                return answer * 2;
        }
}
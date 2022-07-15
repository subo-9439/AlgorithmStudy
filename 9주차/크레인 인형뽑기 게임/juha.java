import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int col : moves){
            for(int row = 0; row < board.length; row++){
                if(board[row][col - 1]!=0){
                    int toy = board[row][col - 1];
                    board[row][col - 1] = 0;
                    if(!stack.isEmpty() && toy == stack.peek()){
                        while(!stack.isEmpty() && stack.peek() == toy) {
                            stack.pop();
                            answer++;
                        }
                        answer++;
                    }else{
                        stack.add(toy);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
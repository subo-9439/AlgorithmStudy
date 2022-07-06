import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<moves.length; i++){
            int jIdx=0;
            int temp=0;
            for(int j = 0; j<board.length; j++){
                if(board[j][moves[i]-1]!=0){
                    temp=board[j][moves[i]-1];
                    if(!stack.empty()&&stack.peek()==temp){
                        answer=answer+2;
                        temp=0;
                        stack.pop();
                        board[j][moves[i]-1]=0;
                    }else{
                        stack.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1]=0;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
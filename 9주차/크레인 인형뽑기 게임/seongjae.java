import java.util.ArrayList;
import java.util.Stack;

class Crain_soultion {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // moves의 숫자 1 -> board 인덱스 0번
        // 이차원 배열을 이차원 스택으로 바꾸기
        ArrayList<Stack> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new Stack());
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = board.length-1; j >= 0; j--) {
                if(board[j][i] != 0)
                    list.get(i).push(board[j][i]);
            }
        }
        // 상자를 담을 스택 생성
        Stack box = new Stack<>();
        // moves를 순회하며 상자에 담기
        for(int i : moves){
            if(!list.get(i-1).empty()) {
                // moves 요소에 해당하는 스택의 값을 빼서
                Object temp = list.get(i-1).pop();
                // 상자에 가장 위에 있는놈과 같으면, 삭제하고 answer + 2
                if(!box.empty() && (int)box.peek() == (int)temp) {
                    box.pop();
                    answer += 2;
                    // 상자가 비어있거나, 값이 같지 않으면, 그 값을 상자에 넣는다.
                } else {
                    box.push(temp);
                }
            }
        }
        return answer;
    }
}

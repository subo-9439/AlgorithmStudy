import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();   // BFS를 진행할 Queue
        int[] words_cnt = new int[words.length];    // 변환 단계를 저장할 배열
        boolean[] visited = new boolean[words.length];  // 방문 여부를 저장할 배열
        q.add(begin);   // 맨 처음에 글자를 삽입한다.
        while(!q.isEmpty()){    //Queue에 값이 존재하지 않으면 종료.
            String p = q.poll();
            int p_index = -1;   // P의 index
            for(int i = 0; i<words.length; i++){    // P의 index 찾기
                if(words[i].equals(p))
                    p_index = i;
            }
            if(p.equals(target)){   //만약 P가 target이라면, return
                return words_cnt[p_index];
            }
            for(int i = 0; i<words.length; i++){
                int cnt = 0;
                for(int j = 0; j<p.length(); j++){
                    if(p.charAt(j) != words[i].charAt(j))   //각 자리마다 값이 다르면 +1
                        cnt++;
                }
                if(!visited[i] && cnt == 1){    // 값이 하나만 다르고, 방문하지 않았을 때
                    q.add(words[i]);    // Queue에 삽입하고
                    visited[i] = true;  // 방문여부 check
                    if(p_index==-1) // -1인 경우는 맨 처음일 경우이므로
                        words_cnt[i] = 1;   // 1로 지정
                    else    // 처음이 아니라면
                        words_cnt[i] = words_cnt[p_index] + 1;  // p_index의 배열값에서 +1
                }
            }
        }
        return 0;   // 만약 위의 상황에서 return 되지 않았다면 도달할 수 없으므로 return 0
    }
}
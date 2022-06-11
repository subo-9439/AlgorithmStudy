public class subo {

    boolean[] visited;
    int minLen;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        minLen = 10;// 최대 9번의 단계가 필요하기떄문에 그보다 큰 10을 넣어줌
        visited = new boolean[words.length];
        dfs(begin,target,words,0);
        if(minLen == 10) return 0;
        return answer = minLen;
    }

    //순열
    public void dfs(String begin,String target, String[] words, int cnt){
        if(begin.equals(target)){//같은단어가 나오면 몇단계인지 저장
            minLen = Math.min(minLen,cnt);
        }else {
            for (int i = 0; i < words.length; i++){
                String cur = words[i];
                if (visited[i]) continue;
                if(isPossible(begin,cur)){
                    visited[i] = true;
                    dfs(cur,target,words,cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    //바꿀단어는 딱하나여야만함
    //여러개가 바뀔 수 있는 경우로 들어가버리면 그 단어를 다시는 쓸 수 없음.
    public boolean isPossible(String a, String b){
        int cnt = 0;
        for (int i = 0; i < a.length();i++){
            if(a.charAt(i) == b.charAt(i)) cnt++;
        }
        if(a.length()-cnt == 1) return true;
        return false;
    }

}

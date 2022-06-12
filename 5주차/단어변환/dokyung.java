class dokyung {
    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        //목표 글자와 동일해졌다면 종료
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        //words길이만큼 반복
        for (int i = 0; i < words.length; i++) {
            //방문한 곳 이라면 건너뛰기
            if (visited[i]) {
                continue;
            }

            //같은 스펠링 몇개인지 세기
            int count = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    count++;
                }
            }

            // 한글자 빼고 모두 같은 경우, 방문한것으로 한다.
            if (count == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                //다시 비교하기 위해서 방문 초기화
                visited[i] = false;
            }
        }
    }
}
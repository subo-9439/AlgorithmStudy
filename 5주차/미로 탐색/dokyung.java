import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dokyung {

    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; //x좌표
    static int[] dy = { 0, 0, -1, 1 }; //y좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //2차원 배열 생성
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        //방문배열
        visited = new boolean[n][m];

        //시작
        visited[0][0] = true;

        bfs(0, 0);

        //도착위치
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        //좌표저장
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                //범위를 넘어서면 건너뛰기
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                //방문했거나 값이 0이면 건너뛰기
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;
                //제대로 방문했으면 Q에 저장
                queue.add(new int[] {nextX, nextY});
                //해당 위치에 현재값 + 1 저장 (방문횟수)
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
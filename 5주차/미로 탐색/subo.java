import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class subo {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] map;
    static boolean[][] visit;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++){
            String s = scan.nextLine();
            for (int j = 0; j < s.length(); j++){
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        int[][] dist = new int[N][M];   // 거리를 담아줄 배열
        queue.add(0);//x
        queue.add(0);//y
        visit[0][0] = true;             //0 ,0 좌표
        dist[0][0] = 1;

        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for (int k = 0; k < 4; k++){
                int dx = x + dir[k][0];
                int dy = y + dir[k][1];
                if (dx >= N || dy >= M || dx < 0 ||dy < 0)continue;
                if (visit[dx][dy] || map[dx][dy] == 0)continue;
                queue.add(dx);
                queue.add(dy);
                visit[dx][dy] = true;
                dist[dx][dy] = dist[x][y]+1;
            }
        }
        System.out.println(dist[N-1][M-1]);

    }
    public static void main(String[] args) {
        input();
        bfs();

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null|| !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }

}
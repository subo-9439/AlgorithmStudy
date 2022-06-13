import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class dokyung {

    static int[][] arr;
    static int N,M,V;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //필요한 초기화들
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int j=0; j<N+1;j++){
            Arrays.fill(arr[j], 0);
        }
        Arrays.fill(visited,false);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited,false);
        bfs(V);
    }


    public static void dfs(int start){
        visited[start]=true;
        System.out.print(start+" ");
        for (int i = 1; i <= N ; i++) {
            if (arr[start][i]==1&&visited[i]==false){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start]=true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll+" ");
            for (int i = 1; i <= N; i++) {
                if (arr[poll][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
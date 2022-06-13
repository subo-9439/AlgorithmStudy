import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Nick {

    static int n;
    static int m;
    static int v;
    static boolean[][] adjacencyMatrix;
    static boolean[] visited;
    static StringBuffer visitString;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        adjacencyMatrix = new boolean[n + 1][n + 1];

        String line = br.readLine();;
        while (line != null) {
            String[] l = line.split(" ");
            int i = Integer.parseInt(l[0]);
            int j = Integer.parseInt(l[1]);
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
            line = br.readLine();
        }
        br.close();

        /* dfs 호출 */
        visitString = new StringBuffer();
        visitString.append(v).append(" ");
        visited = new boolean[n + 1];
        visited[v] = true;
        dfs(v);
        System.out.println(visitString.toString());

        /* bfs 호출 */
        visitString = new StringBuffer();
        visitString.append(v).append(" ");
        visited = new boolean[n + 1];
        visited[v] = true;
        bfs(v);
        System.out.println(visitString.toString());
    }

    private static void bfs(int v) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(v);
        while (!bfsQueue.isEmpty()) {
            int nowVertex = bfsQueue.poll();
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[nowVertex][i] && !visited[i]) {
                    visitString.append(i).append(" ");
                    visited[i] = true;
                    bfsQueue.add(i);
                }
            }
        }
    }

    private static void dfs(int v) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[v][i] && !visited[i]) {
                visitString.append(i).append(" ");
                visited[i] = true;
                dfs(i);
            }
        }
    }

}

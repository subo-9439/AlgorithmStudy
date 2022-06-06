import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, v;
    static int x, y;
    static ArrayList[] connectList;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken()) - 1;

        connectList = new ArrayList[n];
        for (int i = 0; i < n; i++){
            connectList[i] = new ArrayList<Integer>();
        }
        // 인접리스트로 만들기 -> 인접행렬도 가능!
        for (int i = 0; i < m; i++){
            String[] s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]) - 1;
            y = Integer.parseInt(s[1]) - 1;
            connectList[x].add(y);
            connectList[y].add(x);
        }

        for (int i = 0; i < n; i ++){
            Collections.sort(connectList[i]);
        }

        // dfs(스택)과 bfsg(큐) 실행
        dfs();
        sb.append("\n");
        bfs();
        System.out.println(sb.toString());
    }

    public static void dfs(){
        Stack<Integer> s = new Stack<>();
        visited = new boolean[n];
        s.push(v);
        while (s.size() != 0){
            int temp = s.pop();
            if (visited[temp]) continue;

            visited[temp] = true;
            sb.append(temp + 1).append(" ");
            for (int i = connectList[temp].size() - 1; i > -1; i--){
                int t = (int)connectList[temp].get(i);
                if (!visited[t]){
                    s.push(t);
                }
            }
        }
    }

    public static void bfs(){
        visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (q.size() != 0){
            int temp = q.poll();
            if (visited[temp]) continue;

            sb.append(temp + 1).append(" ");
            visited[temp] = true;
            for (int i = 0; i < connectList[temp].size(); i++){
                int t = (int)connectList[temp].get(i);
                if (!visited[t]){
                    q.add(t);
                }
            }
        }
    }
}

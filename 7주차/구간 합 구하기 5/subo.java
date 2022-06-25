import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subo {
    static FastReader scan = new FastReader();
    static int N,M;
    static int[][] map;
    static int[][] dp;
    static Queue<Integer> list = new LinkedList<>();
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];//dp[x,y] = map[1,1] ~ map[x,y]까지의 합

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                map[i][j] = scan.nextInt();
                dp[i][j] = map[i][j];
            }
        }
        for (int i = 1; i <= M; i++) {
            list.add(scan.nextInt());
            list.add(scan.nextInt());
            list.add(scan.nextInt());
            list.add(scan.nextInt());
        }
    }
    static void pro(){
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                dp[i][j] += dp[i][j-1];
            }
        }
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                dp[i][j] += dp[i-1][j];
            }
        }
        while (!list.isEmpty()){
            int x1 = list.poll();
            int y1 = list.poll();
            int x2 = list.poll();
            int y2 = list.poll();
            System.out.println(dp[x2][y2]-dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
        }

    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null ||!st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
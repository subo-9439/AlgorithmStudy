import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class dokyung {

    public static int[] arr;
    //빨리 출력하기
    public static StringBuilder sb = new StringBuilder();
    public static int N,M;


    public static void main(String[] args) throws IOException {
        //빨리 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0,0);

        System.out.println(sb);
    }
    //start = 탐색이 진행될 수록 증가해야한다.
    public static void dfs(int start, int depth){
        if(depth==M){
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth]=i+1;
            //다음 탐색에서 i가 하나씩 증가
            dfs(i+1,depth+1);
        }
    }
}
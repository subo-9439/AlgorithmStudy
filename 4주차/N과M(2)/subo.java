import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subo {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visited;
    static int[] temp;
    
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        temp = new int[N+1];
        visited = new boolean[N+1];
    }
    
    static void combination(int idx, int cnt){
        if(cnt == M){
            for (int i = 1; i <= M; i++){
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
        }else {
            //1부터 N까지의 숫자를 temp에 담아주자
            //수열은 항상 전의 숫자보다 큰 값이 뒤로 온다.
            for (int num = temp[idx-1] + 1; num <= N ; num++){
                temp[idx] = num;
                combination(idx+1,cnt+1);
            }
        }
    }
    
    public static void main(String[] args) {
        input();
        combination(1,0);
        System.out.println(sb.toString());
    }
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null||!st.hasMoreTokens()){
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
    }
}

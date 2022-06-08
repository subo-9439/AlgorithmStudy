import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int num;
    static int length;
    static int[] iarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        iarr = new int[length-1];

        dfs(1,1,bw);

        bw.flush();
        bw.close();
    }
    /*
    1.종료조건 : depth와 length와 같아졌을 때, iarr에 있는 문자를 다 버퍼고 한줄 내린다.
     */
    public static void dfs(int depth, int idx, BufferedWriter bw) throws IOException {
        if(depth==length){
            for(int i = idx; i<=num; i++){
                for(int inner : iarr){
                    bw.write(inner+" ");
                }
                bw.write(""+i);
                bw.newLine();
            }
        }else{
            //조합과 같은 형태이다.
            for(int i =idx; i<=num; i++){
                iarr[depth-1]=i;
                dfs(depth+1,i+1, bw);
            }
        }
    }
}

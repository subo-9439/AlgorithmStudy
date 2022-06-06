import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int result=0;
    static int[] iarr;
    /*
    메모리 친구 때문에 진짜 몇번을 바꾼지 모르겠음.
    값은 계속 제대로 나왔지만 메모리 문제로 10회 이상 수정
    가장 중요했던 부분 -> "객체를 최대한 생성하지 말 것"
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        boolean[] chk = new boolean[n];
        iarr= new int[n];
        int depth = 1;
        dfs(depth,chk);
        bw.write(""+result);
        bw.flush();
        bw.close();
    }
    /*
    1. depth는 체스판의 행
    2. for문의 int i는 체스판의 열
    3. boolean은 하나로만 사용
     */
    public static void dfs(int depth, boolean[] chk){
        if(depth==n){
            for(int i = 0; i<n; i++){
                if(!chk[i]){
                    result++;
                }
            }
        }else{
            for(int i = 0; i<n; i++){
                if(!chk[i]){
                    iarr[depth-1]=i;
                    dfs(depth+1,makeBooleanArray(depth,chk));
                    iarr[depth-1]=0;
                    makeBooleanArray(depth-1,chk);
                }
            }
        }
    }
    /*
    1. 다음 행에서 사용하지 못하는 부분을 true로 변환 시킨다.
     */
    public static boolean[] makeBooleanArray(int depth, boolean[] next){
        Arrays.fill(next,false);
        for(int i = 0; i<depth; i++){
            next[iarr[i]]=true;
            if(iarr[i]+depth-i<n) next[iarr[i]+depth-i]=true;
            if(iarr[i]-depth+i>-1) next[iarr[i]-depth+i]=true;
        }
        return next;
    }
}

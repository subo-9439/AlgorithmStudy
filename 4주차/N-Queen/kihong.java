import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int result=0;
    static int[] iarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        boolean[] chk = new boolean[n];
        iarr= new int[n];
        int[] pls = new int[n];
        int depth = 1;
        dfs(depth,chk);
        bw.write(""+result);
        bw.flush();
        bw.close();
    }

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

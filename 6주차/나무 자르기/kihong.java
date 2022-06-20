import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static long M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Long.parseLong(st.nextToken());
        M=Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] namu = new long[(int)N];
        long min = 0;
        long max = 0;
        for(int i=0; i<N; i++){
            namu[i]=Long.parseLong(st.nextToken());
            if(max<namu[i]) max= namu[i];
        }
        long sum = 0;
        long average =0;
        while(true){
            average=(min+max)/2;
            for(int i = 0; i<N; i++){
                if(0<namu[i]-average){
                    sum+=namu[i]-average;
                }
            }
            if(M==sum) break;
            if(M<sum) {
                if(min==average) break;
                min=average;
            }
            if(M>sum) {
                max = average;
            }
            sum=0;
        }
        bw.write(String.valueOf(average));




        bw.flush();
        bw.close();
    }

}
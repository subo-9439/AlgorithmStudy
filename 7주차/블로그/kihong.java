import java.io.*;
import java.util.*;

public class Main {
    static int x;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int[x];
        for(int i =0; i<x;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int max=0; // 가장 누적 방문자가 많았을 때의 누적방문자 수
        int cnt=1; // max가 같은날 카운트
        int one=0; // 시작
        int two=n-1; // 기간 n-1
        int sum=0; // 단위 기간동안 누적 방문자 수
        for(int i = one; i<=two; i++){
            sum+=arr[i];
        }
        max=sum;
        while(two<x-1){
            sum-=arr[one];
            one++;
            two++;
            sum+=arr[two];
            if(sum>max) {
                max=sum;
                cnt=1;
                continue;
            }
            if(sum==max){
                cnt++;
            }
        }
        if(max==0){
            bw.write("SAD");
        }else{
            bw.write(String.valueOf(max));
            bw.newLine();
            bw.write(String.valueOf(cnt));
        }

        bw.flush();
        bw.close();
    }

}




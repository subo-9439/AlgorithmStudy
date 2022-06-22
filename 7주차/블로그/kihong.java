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
        int max=0;
        int cnt=1;
        int one=0;
        int two=n-1;
        int sum=0;
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




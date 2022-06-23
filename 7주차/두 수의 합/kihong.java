import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        //정렬 후 양 끝점에서 모이도록
        //투포인터는 두 가지 방식을 이용한다.
        //1. 중간에서 만나는 포인터 or 2. slower and faster
        int cnt = 0;
        for(int i =0; i<n; i++){
            for(int j =n-1; j>i; j--){
                if(arr[i]+arr[j]==x) cnt++;
                if(arr[i]+arr[j]<=x) break;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

}

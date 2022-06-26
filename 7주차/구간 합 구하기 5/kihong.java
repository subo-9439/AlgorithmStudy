import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][n];

        //columm의 값을 계속 더해주는 배열을 작성한다.
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            for(int j = 1; j<n; j++){
                arr[i][j]=arr[i][j-1]+Integer.parseInt(st.nextToken());
            }
        }
        int[] row_one=new int[m];
        int[] columm_one=new int[m];
        int[] row_two=new int[m];
        int[] columm_two=new int[m];
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            row_one[i]=Integer.parseInt(st.nextToken());
            columm_one[i]=Integer.parseInt(st.nextToken());
            row_two[i]=Integer.parseInt(st.nextToken());
            columm_two[i]=Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int[] sum = new int[m];
        //그냥 시간복잡도를 n^2로 했을 시 시간 초과가 발생하여 배열을 더하는 형식으로 바꿨다.
        while(cnt<m){
            for(int i =row_one[cnt]; i<=row_two[cnt]; i++){
                if(columm_one[cnt]-1==0){
                    sum[cnt]+=arr[i-1][columm_two[cnt]-1];
                }else{
                    sum[cnt]+=arr[i-1][columm_two[cnt]-1]-arr[i-1][columm_one[cnt]-2];
                }
            }
            cnt++;
        }
        int cnt_two=0;
        while(cnt_two<m){
            System.out.println(String.valueOf(sum[cnt_two]));
            cnt_two++;
        }

        bw.flush();
        bw.close();
    }

}


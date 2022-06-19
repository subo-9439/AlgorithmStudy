import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subo {

    static FastReader scan = new FastReader();
    static int N,M;
    static int[] arr;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];
        for (int i = 0 ; i < N; i++){
            arr[i] = scan.nextInt();
        }
    }
    static void pro(){
        int L=0,R= 1000000000;  
        int ans = 0;
        while (L<=R) {
            int mid = (L+R)/2;  //자를 나무의 단위
            if(canGet(mid)){//원하는만큼 이상으로 가져갈 수 있다!
                L = mid+1 ;
                ans = mid;
            }else {     //단위가 너무 커서 원하는만큼 못가져간다.
                R = mid-1;
            }

        }
        System.out.println(ans);
    }
    static boolean canGet(int h){
        long sum = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > h) sum+= arr[i]-h;
        }
        return sum >= M;        //합이 M이상일 때 만 true
    }
    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreTokens()){
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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}

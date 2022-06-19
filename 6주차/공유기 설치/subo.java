import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class subo {
    static FastReader scan = new FastReader();
    static int N, C;
    static int[] arr;
    static void input(){
        N = scan.nextInt(); C = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) arr[i] = scan.nextInt();
    }
    static void pro(){
        int ans =0;

//        int L = arr[0] , R = arr[N-1] //를하면 예외케이스가 생김
//        int L = 0, R = 1000000000;   //최대 나올 수 있는 거리차이는 0~ 10억까지 또는
        int L = 1,R = arr[N-1];   //거리차이는 1에서 arr[N-1]까지
        while (L <= R){
            int dist = (L+R)/2;
            if(canRouter(dist)){//공유기를 C개 이상 설치할 수 있으니까 한번 거리를 늘리자 -> 집과 집사이의 거리를 늘리면 설치할 수 있는 공유기가 줄어든다.
                L = dist + 1;
                ans = dist;
//                System.out.println("현재값은 : " + ans);
            }else {//공유기를 C개도 설치 못하니까 설치간격을 좁혀야한다.
                R = dist - 1;
            }
        }
        System.out.println(ans);
    }
    static boolean canRouter(int dist){     //dist 변수는 집간격이 될 수 있는 최소의 값
        Arrays.sort(arr);   //순서대로 정렬
        int pos = arr[0]; //현재 공유기 설치위치
        int cnt = 1;      //설치한 공유기 대수

        for (int i = 1; i < N; i++){
            if(arr[i] - pos >= dist) {
                cnt++;    //(공유기가 설치된)집과 집사이의 거리가 dist 보다 크거나 같으면 공유기를 설치하자!
                pos = arr[i]; // 공유기 위치 갱신
            }

        }
        return cnt >= C;            //공유기 개수가 C보다 많으면 true
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

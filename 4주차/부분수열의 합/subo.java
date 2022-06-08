import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subo {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N, M, cnt;
  static int[] arr,temp;

  static void input(){
      N = scan.nextInt();
      M = scan.nextInt();
      arr = new int[N];
      for (int i = 0;  i < N; i++) arr[i] = scan.nextInt();
  }
  
  static void rec(int idx,int sum){
      if(idx == N){
          if(sum == M)  cnt++;
      }else {
          //해당idx값을 더해준다.
          rec(idx+1, sum + arr[idx]);
          //해당idx값을 안더해줌
          rec(idx+1,sum);
      }
  }
  
  public static void main(String[] args) {
      input();
      rec(0, 0);
      //예외 값이 하나 있다 만약 M이 0일 때 공집합도 개수에 추가가 되어버린다.
      //문제 조건에서 공집합을 제외한 크기가 양수인 부분수열이므로 cnt -1을 해주어야한다.
      if(M == 0) cnt--;
      System.out.println(cnt);
  }

  static class FastReader{
      BufferedReader br;
      StringTokenizer st;
      FastReader(){
          br = new BufferedReader(new InputStreamReader(System.in));
      }

      String next(){
          while (st==null||!st.hasMoreTokens()){
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
  }
}

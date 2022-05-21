import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subo {
  static FastReader scan = new FastReader();
  static int N, M;
  static void input(){
      N = scan.nextInt();
      M = scan.nextInt();
  }

  public static void main(String[] args) {
      input();
      int ans = 1;
      if(N == 1){
          ans = 1;
      }
      else if(N == 2) {
          ans = Math.min((M+1)/2, 4);
      }
      else if(M < 7){
          ans = Math.min(M,4);
      }else {
          ans = M-2;//M-7+5
      }
      System.out.println(ans);
  }
  static class FastReader{
      BufferedReader br;
      StringTokenizer st;

      public FastReader(){
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
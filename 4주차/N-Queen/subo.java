import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class subo {

  static FastReader scan = new FastReader();
  static int N,cnt;
  static int[] queen;

  static void input(){
      N = scan.nextInt();
      queen = new int[N];
  }

  static void rec(int row){

      if (row == N){
          cnt++;
          return;
      }
      //지금 행에서
      for (int col = 0; col < N; col++){    //각 열에 대해 검증을 한다.
          boolean possible = true;
          for (int r = 0; r < row; r++){  //그전 퀸 중에 공격가능한 퀸이 있으면 안된다.
            if(attack(r,queen[r], row, col))  {
            possible = false;
            break;
            }
          }


          if (possible){  //둘 수 있는 곳이면 행을 증가 시켜준다.
              queen[row] = col;
              rec(row+1);
          }
      }
  }

  static boolean attack(int x1, int y1, int x2, int y2){      //열과 대각선은 퀸을 둘 수 없다
      if(y1 == y2) return true;
      if(Math.abs(x1-x2) == Math.abs(y1-y2)) return true;
      return false;
  }

  public static void main(String[] args) {
      input();
      rec(0);
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

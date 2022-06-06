import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subo {
    static FastReader scan = new FastReader();
    static String N;
    static int[] cnt;//0~9 숫자

    static void input(){//입력단
        N = scan.next();
        cnt = new int[10];
    }

    static void pro(){//프로세스

        for (int i = 0; i < N.length(); i++)  {
            //6이나 9로직
            if(Character.getNumericValue(N.charAt(i)) == 6)  cnt[9]++;
            if(Character.getNumericValue(N.charAt(i)) == 9)  cnt[6]++;
            cnt[Character.getNumericValue(N.charAt(i))]++;
        }

        //최솟값을 구하려면 숫자가 가잖 많이 쓰여진 만큼 필요하다.
        int max = 0;
        for (int i = 0; i < 10; i++){
            if(i == 6 || i == 9) cnt[i]= (int) Math.ceil(cnt[i]/2.0);//6이나 9로직
            max = Math.max(cnt[i],max);
        }
        System.out.println(max);
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
            while (st==null || !st.hasMoreTokens()){
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
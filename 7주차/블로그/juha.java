import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] days = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            days[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int sum = 0;
        int period = 0;
        int point = 0;
        for(int i = 0; i<N; i++){
            while((point-i < X) && point<N){
                sum += days[point];
                point++;
            }
            if(max == sum)
                period++;
            else if(max < sum){
                max = sum;
                period = 1;
            }

            sum -= days[i];
        }
        if(max == 0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(period);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dokyung {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 구간 합을 반복문으로 구해서 비교한다?

        int sum =0;

        for(int i=0;i<x;i++)
            sum+= arr[i];

        int answer = sum;
        //일단 하나
        int count = 1;

        for(int i= x;i<n;i++) {
            //다음것 더하고
            sum += arr[i];
            //이전것 빼고
            sum -= arr[i-x];

            //더 큰 값이 나타나면 초기화
            if(answer < sum) {
                answer = sum;
                count = 1;
            }
            //같은 값이 나타났다
            else if(answer == sum)
                count++;
        }

        if(answer ==0)
            System.out.println("SAD");

        else {
            System.out.println(answer);
            System.out.println(count);
        }

    }
}
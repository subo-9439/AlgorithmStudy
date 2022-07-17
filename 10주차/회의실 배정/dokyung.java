import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());	// 시작시간
            time[i][1] = Integer.parseInt(st.nextToken());	// 종료시간
        }

        // 모두비교 -> 너무 비효율적임

        // 정렬해서 빨리 끝나는 것만 모으기?
        // 정렬해서 시간 맞는것 끼리 모으기?

        // 정렬해서 마치는 시간과 시작시간이 비슷한것 중에서, 실행시간이 적은것 선택

        Arrays.sort(time, (st, fn) -> {
            if(st[1] == fn[1]) { //종료시간이 같으면 시작 시간으로 정렬
                return st[0] - fn[0];
            }
            return st[1] - fn[1];
        });

        int count = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            if(start <= time[i][0]) {
                start = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
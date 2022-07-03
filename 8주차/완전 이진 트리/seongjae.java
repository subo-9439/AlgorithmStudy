import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class seongjae {
    // 깊이를 저장할 변수
    static int K;
    // 입력 수를 저장할 배열
    static int[] arr;
    // 층별, 노드를 저장할 배열
    static StringBuffer[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, K) - 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);

            ans = new StringBuffer[K];

            // 전체의 중앙값부터 좌측 자식, 우측자식 순으로, 층별 중앙값을 저장하는 재귀 순회
            solve(0, arr.length -1, 0);
            // 층순으로 저장된 순서대로, 값을 출력
            for (int j = 0; j < K; j++)
                bw.write(ans[i].toString()+ "\n");

            bw.flush();
        }
    }
    public static void solve(int s, int e, int floor) {
        // 깊이 K까지만 순회하도록 return문 선언
        if (floor == K)
            return;

        // 중앙값을 층별 노드에 저장한다.
        int m = (s + e) / 2;
        ans[floor].append(arr[m] + " ");

        // 왼쪽 자식으로 재귀
        solve(s, m-1, floor + 1);
        // 오른쪽 자식으로 재귀
        solve(m+1, e, floor + 1);
    }
}

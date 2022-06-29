import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums); //투포인트 탐색을 위해 정렬

        int ans = Integer.parseInt(br.readLine());
        int count = 0;

        left = 0;
        right = n - 1;
        while (left < right) {
            // 구해야하는 값보다 값이 크면 오른쪽 포인터를 이동
            if (nums[left] + nums[right] > ans) {
                right--;
                continue;
            } 
            // 구해야하는 값과 같으면 count를 증가시키고 왼쪽 포인터를 이동
            else if (nums[left] + nums[right] == ans) count++;
            left++;
        }
        System.out.println(count);
    }
}

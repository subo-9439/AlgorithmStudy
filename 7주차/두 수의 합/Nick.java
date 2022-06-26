import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Nick {

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        StringTokenizer arrs = new StringTokenizer(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrs.nextToken());
        }
        int x = sc.nextInt();

        // 연산
        Arrays.sort(arr);
        int count = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == x) {
                count++;
                r--;
                l++;
            }
            else if (sum < x){
                l++;
            }
            else {
                r--;
            }
        }

        // 출력
        System.out.println(count);
    }

}

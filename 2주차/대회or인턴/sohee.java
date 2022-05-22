import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;

        // 팀을 짤 수 있으면 계속 빼줌
        while (n >= 2 && m >= 1){
            n -= 2;
            m -= 1;
            if (n + m >= k) ans += 1;
        }
        System.out.println(ans);
    }
}

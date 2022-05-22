import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;

        // 4가지 이동이 가능한 경우
        if (n > 2 && m >= 7){
            // 4가지 이동 방법 사용 후 남은 거리 계산 & 방문 칸수 추가
            ans += 5;
            m -= 7;
        }
        // 4가지 이동이 불가한 경우
        else {
            if (n == 1) m = 1; // 세로 길이가 1이면 이동 불가
            else if (n == 2) { // 세로 길이가 2면 2, 3번 조합만 사용 가능
                m = (m - 1) / 2 + 1;
                if (m > 4) m = 4; // 4번이상 이동할 수 없음 -> 이동 가능한 가로길이를 3으로 변경
            }
            else{
                if (m > 4) m = 4;
            }
        }

        // 나이트는 오른쪽으로만 이동한다.
        // 오른쪽으로 최대한 적게 움직여야 많은 칸을 방문할 수 있다.
        // 1, 3번 조합을 사용하면 한 열에 한 칸씩 방문 가능
        ans += m;
        System.out.println(ans);
    }
}

package CodingTest;

import java.util.Scanner;

public class 대회or인턴 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        // 여2, 남 1 -> 한팀
        // 인턴쉽 k명
        // 6,3,2 일때 1팀 -> 4,2,2 -> 2팀 -> 2,1,2 -> 3팀 -> 0,0,2 (이땐 인턴쉽 갈 사람이 없기때문에 3팀은 안됨)
        // n은 -2씩 m 은 -1씩 후 n+m-3이 k보다 작으면 더이상 팀 불가.
        int team = 0;

        while(n >= 2 && m >=1 && n+m-3 >= k) {
            n = n-2;
            m--;
            team++;
        }
        System.out.println(team);

    }
}


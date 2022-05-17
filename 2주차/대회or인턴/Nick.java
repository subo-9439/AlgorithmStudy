import java.util.Scanner;

public class Nick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int female = sc.nextInt();
        int male = sc.nextInt();
        int intern = sc.nextInt();

        /*
        * 팀 하나 당, 여2 + 남1 / 인턴은 아무나 1
        * */
        int teamCount = 0;

        /* 일단 팀을 가능한대로 구성한다 */
        while (female >= 2 && male >= 1) {
            female -= 2;
            male -= 1;
            teamCount++;
        }

        if (female + male < intern) { /* 남은 인원으로 인턴 커버 불가능하면 */

            intern -= female + male; /* 일단 남은 인원 최대한 빼고 */

            while (intern > 0) { /* 최소한으로 팀을 부셔야 한다 (깰때마다 팀카운트 줄인다) */
                teamCount--;
                intern -= 3;
            }
        }

        System.out.println(teamCount); /* 출력 */

    }

}

import java.util.Scanner;

public class Nick { // 백준 실버3 - 1913 달팽이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int number = sc.nextInt(); //좌표를 반환해야 하는 숫자
        sc.close();
        // 입력부 끝

        int[][] field = new int[n + 1][n + 1]; // 달팽이가 그려질 필드 : 출력값 1
        int[][] direction = {
                {-1, 0}, // 상
                {0, 1}, // 우
                {1, 0}, // 하
                {0, -1} // 좌
        }; // 필드 이동을 시행할 순서대로 방향을 정의한다.


        int[] position = {-1 ,-1}; // 좌표. 0번째가 x, 1번째가 y. 최초 위치는 1의 좌표로 초기화.
        if (n % 2 != 0) {
            position[0] = n / 2 + 1;
            position[1] = n / 2 + 1;
        }
        else {
            position[0] = n / 2 + 1;
            position[1] = n / 2;
        }
        int[] numberPosition = {position[0], position[1]}; // number의 좌표를 기억할 변수. : 출력값 2

        int now = 1; // 집어넣을 숫자
        int step = 1; // 한 방향으로 이동을 진행할 칸 수
        int nowStep = 0; // 한 방향으로 이동을 진행한 칸 수
        int nowDirection = 0; // direction의 index. 제일 먼저 움직일 방향은 '상'으로 초기화 해둔다.
        int numberForCalcStep = 2; // step을 늘려나갈 기준 숫자. now가 calcStep^2에 도달할 때마다 step++, numberForCalcStep++ 한다.

        field[position[0]][position[1]] = now; // 1은 필드에 미리 입력해둔다.
        while (now < Math.pow(n, 2)) {
            now++;
            /*
            * - nowStep이 step에 도달하도록 한다.
            *   - nowStep이 step에 아직 도달하지 않았다면,
            *       진행 방향으로 이동한다.
            *   - nowStep이 step에 도달했으면,
            *       방향(nowDirection)을 바꿔잡고(nowDirection이 4가 될 차례라면 0을 넣는다), nowStep을 0으로 초기화한다. 그 다음에 진행 방향으로 이동한다.
            *   => 두 경우 다 '진행 방향으로 이동한다'가 동일하므로, 동일한 로직은 뒤쪽에 따로 뺀다. 그렇게 되면, `nowStep==step`인 경우만 체크하면 된다.
            * - 이동한 좌표(position[0], position[1])의 위치(field[position[0]][position[1]])에 현재 숫자(now)를 넣는다.
            * - now가 numberForCalcStep^2에 도달할 때마다 step++, numberForCalcStep++ 한다.
            * - 진행 중에 `now == number`인 케이스를 찾는다면, 해당 좌표를 기억(numberPosition[])해둔다.
            */

            if (nowStep == step) { // nowStep이 step에 도달했으면,
                // 방향(nowDirection)을 바꿔잡고(nowDirection이 4가 될 차례라면 0을 넣는다),
                if (nowDirection == 3) nowDirection = 0;
                else nowDirection++;

                nowStep = 0; // nowStep을 0으로 초기화한다.
            }

            // 진행 방향으로 이동한다.
            position[0] += direction[nowDirection][0];
            position[1] += direction[nowDirection][1];
            nowStep++;

            // - 이동한 좌표(position[0], position[1])의 위치(field[position[0]][position[1]])에 현재 숫자(now)를 넣는다.
            field[position[0]][position[1]] = now;

            // - now가 numberForCalcStep^2에 도달할 때마다 step++, numberForCalcStep++ 한다.
            if (now == Math.pow(numberForCalcStep, 2)) {
                step++;
                numberForCalcStep++;
            }

            // - 진행 중에 `now == number`인 케이스를 찾는다면, 해당 좌표를 기억(numberPosition[])해둔다.
            if (now == number) {
                numberPosition[0] = position[0];
                numberPosition[1] = position[1];
            }

        }

        // 출력부 시작
        for (int i = 1; i < field.length; i++) { // 출력값 1(field) 출력
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < field.length; j++) {
                sb.append(field[i][j]).append(" ");
            }
            System.out.println(sb.toString());
        }
        System.out.println(numberPosition[0] + " " + numberPosition[1]); // 출력값 2(number의 좌표) 출력
    }

}
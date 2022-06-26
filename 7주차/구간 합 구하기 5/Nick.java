import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nick {
    /*
    ---
    n : 주어질 행/열의 length (1 ~ 1024)
    m : 합을 구해야 하는 횟수 (1 ~ 100,000)
    x, y : 좌표. 두 개 씩 주어진다. x1 <= x2, y1 <= y2
    ---
    자료형 : 1024 * 1000 * 1000 => int면 충분하다
    메모리 : 든든
    m의 범위 - 100000, 시간제한 1초 : 같은 부분 반복해서 연산하지 말란 이야기
    ---
    가로 합계 테이블을 만들어놓고 가로합을(= (x1,y2)-(x1, y1-1) ) 구한다. m행까지 총 m-y1번 수행(최대 m(100000)번의 더하기 연산). - 괜찮을듯 하다. 괜찮아줬으면 좋겠다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 테이블 크기
        int m = Integer.parseInt(st.nextToken()); // 합계 구할 횟수

        int[][] sumArr = new int[n + 1][n + 1]; // 행row별 합계 테이블
        for (int x = 1; x < sumArr.length; x++) { /* 행별 합계 테이블 채우기 */
            st = new StringTokenizer(br.readLine());
            int rowSum = 0;

            for (int y = 1; y < sumArr.length; y++) {
                int xyValue = Integer.parseInt(st.nextToken());
                rowSum += xyValue;
                sumArr[x][y] = rowSum;
            }
        }

        int[][] mArr = new int[m][4]; // 좌표 테이블
        for (int i = 0; i < mArr.length; i++) { /* 좌표 테이블 채우기 */
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mArr[0].length; j++) {
                int coordinate = Integer.parseInt(st.nextToken());
                mArr[i][j] = coordinate;
            }
        }

        br.close();

        StringBuilder sb = new StringBuilder();
        for (int[] mRow : mArr) {
            int x1 = mRow[0];
            int y1 = mRow[1];
            int x2 = mRow[2];
            int y2 = mRow[3];
            int subtotal = 0;
            for (int x = x1; x <= x2; x++) {
                int rowSubtotal = sumArr[x][y2] - sumArr[x][y1 - 1];
                subtotal += rowSubtotal;
            }

            sb.append(subtotal).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }

}
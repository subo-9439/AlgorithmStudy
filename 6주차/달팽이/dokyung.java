package 달팽이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dokyung {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        snail(N,A);
    }

    public static void snail(int N, int A){
        int[][] answer = new int[N][N];

        //중심의 좌표
        int x = (N / 2);
        int y = (N / 2);

        //방향전환 카운터
        int count = 1;

        //값
        int num = 1;

        while (true){
            for (int i = 0; i < count; i++) {
                answer[y--][x] = num++;
            }
            if(num-1==N*N) break;
            for (int i = 0; i < count; i++) {
                answer[y][x++] = num++;
            }
            //위로, 오른쪽으로 이동을 끝냈으면 아래,왼쪽으로 이동은 한번 더 해야함
            count++;
            for (int i = 0; i < count; i++) {
                answer[y++][x] = num++;
            }
            for (int i = 0; i < count; i++) {
                answer[y][x--] = num++;
            }
            //다음번에는 이동을 한번 더 해야함
            count++;
        }

        StringBuilder sb = new StringBuilder();

        //정답 좌표
        int tx=0, ty=0;

        //하나하나 찾아보기 + 출력하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(A==answer[i][j]) {
                    ty=i+1;
                    tx=j+1;
                }
                sb.append(answer[i][j] +" ");
            }
            sb.append("\n");
        }
        sb.append(ty+" "+tx);
        System.out.println(sb);
    }
}
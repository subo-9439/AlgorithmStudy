import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = sc.nextInt();
        int[][] matrix = getSnail(N);
        StringBuilder sb = new StringBuilder();
        int num_x = 0;
        int num_y = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j]==num){
                    num_x = i+1;
                    num_y = j+1;
                }
                sb.append(matrix[i][j]);
                if(j!=N-1)
                    sb.append(" ");
            }
            if(i!=N-1)
                sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println(num_x+" "+num_y);
    }

    private static int[][] getSnail(int n) {
        int value = 1;
        int[][] arr = new int[n][n];
        int x = n/2;
        int y = n/2;
        arr[x][y] = value++;
        int endX = 0;
        int endY = 0;
        int cnt = 1;

        while(true){

            for(int i = 0; i < cnt; i++){
                arr[--x][y] = value++;
                if(y == endY && x == endX)
                    return arr;
            }

            for(int i = 0; i < cnt; i++){
                arr[x][++y] = value++;
            }

            cnt++;

            for(int i = 0; i < cnt; i++){
                arr[++x][y] = value++;
            }

            for(int i = 0; i < cnt; i++){
                arr[x][--y] = value++;
            }

            cnt++;
        }
    }
}
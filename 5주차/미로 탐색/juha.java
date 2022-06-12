import java.util.*;

public class Main {
    static ArrayList<Integer> dfs_list;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // row
        M = sc.nextInt();   // col
        char[][] matrix = new char[N][];
        boolean[][] visited = new boolean[N][M];
        int[][] new_matrix = new int[N][M];
        for(int i = 0; i<N; i++){
            matrix[i] = sc.next().toCharArray();
        }
        find_at_least_box(matrix,visited,new_matrix);
        System.out.println(new_matrix[N-1][M-1]);
    }

    private static void find_at_least_box(char[][] matrix, boolean[][] visited, int[][] new_matrix) {
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        visited[0][0] = true;
        new_matrix[0][0] = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i<dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (isNotVaild(nx, ny))
                    continue;
                if (!visited[nx][ny] && matrix[nx][ny] != '0') {
                    q.add(new Point(nx, ny));
                    new_matrix[nx][ny] = new_matrix[p.x][p.y]+1;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static boolean isNotVaild(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= M;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}


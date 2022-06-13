import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] miro;
    static Queue<Integer> xqueue = new LinkedList<>();
    static Queue<Integer> yqueue = new LinkedList<>();
    static Queue<Integer> xnext = new LinkedList<>();
    static Queue<Integer> ynext = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        char[] temp;
        for(int i = 0; i<n; i++){
            temp=br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                miro[i][j]=(int)(temp[j]-'0');

            }

        }
        //0,0->n-1,m-1
        int x;
        int y;
        int cnt=1;
        xqueue.add(0);
        yqueue.add(0);
        miro[0][0]=0;
        while(!xqueue.isEmpty()){
            x = xqueue.poll();
            y = yqueue.poll();
            if(x==n-1&&y==m-1) break;
            if(y-1>=0&&miro[x][y-1]==1){
                xnext.add(x);
                ynext.add(y-1);
                miro[x][y-1]=0;
            }
            if(y+1<=m-1&&miro[x][y+1]==1){
                xnext.add(x);
                ynext.add(y+1);
                miro[x][y+1]=0;
            }
            if(x-1>=0&&miro[x-1][y]==1){
                xnext.add(x-1);
                ynext.add(y);
                miro[x-1][y]=0;
            }
            if(x+1<=n-1&&miro[x+1][y]==1){
                xnext.add(x+1);
                ynext.add(y);
                miro[x+1][y]=0;
            }
            if(xqueue.isEmpty()){
                while(!xnext.isEmpty()){
                    xqueue.add(xnext.poll());
                    yqueue.add(ynext.poll());

                }
                cnt++;
            }

        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

}




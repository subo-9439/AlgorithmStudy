import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        num=Integer.parseInt(br.readLine());

        int[][] dalpang = new int[n][n];
        String numidx=1+" "+1;
        int trigger =1;
        int row =0;
        int columm =0;
        int cnt = n*n;

        dalpang[row][columm]=cnt;
        cnt--;
        while(true){
            if(trigger==1){
                while(true){
                    row++;
                    dalpang[row][columm]=cnt;
                    if(cnt==num) numidx=(row+1)+" "+(columm+1);
                    cnt--;
                    if(row+1>=n||dalpang[row+1][columm]!=0){
                        trigger=2;
                        break;
                    }
                }
            }
            if(cnt == 0) break;
            if(trigger==2){
                while(true){
                    columm++;
                    dalpang[row][columm]=cnt;
                    if(cnt==num) numidx=(row+1)+" "+(columm+1);
                    cnt--;
                    if(columm+1>=n||dalpang[row][columm+1]!=0){
                        trigger=3;
                        break;
                    }
                }
            }
            if(trigger==3){
                while(true){
                    row--;
                    dalpang[row][columm]=cnt;
                    if(cnt==num) numidx=(row+1)+" "+(columm+1);
                    cnt--;
                    if(row-1<0||dalpang[row-1][columm]!=0){
                        trigger=4;
                        break;
                    }
                }
            }
            if(trigger==4){
                while(true){
                    columm--;
                    dalpang[row][columm]=cnt;
                    if(cnt==num) numidx=(row+1)+" "+(columm+1);
                    cnt--;
                    if(columm-1<0||dalpang[row][columm-1]!=0){
                        trigger=1;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i<n; i++){
            bw.write(String.valueOf(dalpang[i][0]));
            for(int j =1; j<n; j++){
                bw.write(" "+String.valueOf(dalpang[i][j]));
            }
            bw.newLine();
        }
        bw.write(numidx);


        bw.flush();
        bw.close();
    }

}

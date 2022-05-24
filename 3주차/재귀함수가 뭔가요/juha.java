import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        br.close();

        what_is_recursion_method(0,N,bw);

        bw.flush();
        bw.close();
    }

    private static void what_is_recursion_method(int depth, int n, BufferedWriter bw) throws IOException {
        if(depth==0)
            bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        if(depth>n)
            return;
        String s = "";
        for(int i = 0 ; i<depth; i++)
            s += "____";
        bw.write(s+"\"재귀함수가 뭔가요?\"\n");
        if(depth==n){
            bw.write(s+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }else{
            bw.write(s+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            bw.write(s+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            bw.write(s+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }
        what_is_recursion_method(depth+1,n,bw);
        bw.write(s+"라고 답변하였지.\n");
    }
}

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        //알아서 정렬되는 TreeSet에 모든 요소 삽입
        Set<Integer> iset = new TreeSet<>();
        for (int i = 0; i< length; i++) {
            iset.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        for(int i : iset){
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}

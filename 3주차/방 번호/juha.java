import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] set = new int[10];
        br.close();

        for(char c : N.toCharArray()){
            if(c == '6' || c == '9'){
                if(set[6]>set[9])
                    set[9]++;
                else
                    set[6]++;
            }else{
                set[Character.getNumericValue(c)]++;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(Arrays.stream(set).max().getAsInt()));
        bw.flush();
        bw.close();
    }
}

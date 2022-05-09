import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class subo {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();

        int b = Integer.parseInt(br.readLine());
        for(int i=0; i<b; i++) {
            a.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(a);

        for(int i:a) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}

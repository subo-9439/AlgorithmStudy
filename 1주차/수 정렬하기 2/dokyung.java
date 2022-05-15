import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class dokyung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int first = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < first; i++) {
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);

        for (int i : arrayList) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
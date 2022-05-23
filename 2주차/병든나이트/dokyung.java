import java.util.Scanner;

public class dokyung{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

        int count = 0;

        if(h==1){
            count=1;
        }
        else if(h==2){
            count=(w-1)/2 + 1;
            count = count > 3 ? 4 : count;
        }
        else if(w<7){
            count = w;
            count = count > 3 ? 4 : count;
        }
        else{
            count = 4 + w - 6;
        }
        System.out.println(count);
    }
}

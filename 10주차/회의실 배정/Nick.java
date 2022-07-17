import java.util.*;
interface Nick {
    static void main(String[] args) throws Exception {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),c=0,p=0;
        int[][] a=new int[n][2];

        for(int i=0;i<n;i++){
            a[i][0]=s.nextInt();
            a[i][1]=s.nextInt();
        }

        Arrays.sort(a,(o,t)->o[1]==t[1]?o[0]-t[0]:o[1]-t[1]);

        for(int[] v:a)if(p<=v[0]){p=v[1];c++;}

        System.out.println(c);
    }
}

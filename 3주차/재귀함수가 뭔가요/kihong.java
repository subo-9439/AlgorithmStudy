import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        makeString(0,num);

    }
    /*
    print를 진행합니다
    1. underbar의 개수를 depth가 올라갈 수록 증가시킵니다.
    2. 종료 조건 : depth와 num이 같아질 때
    3. 해당되는 출력값을 출력
    4. 재귀를 실행 depth의 값은 1증가 시킵니다.
     */
    public static String makeString(int depth, int num){
        String underBar="";
        for(int i =0; i<depth; i++ ){
            underBar+="____";
        }
        System.out.println(underBar+"\"재귀함수가 뭔가요?\"");
        if(depth==num) {
            System.out.println(underBar+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(underBar+"라고 답변하였지.");
            return null;
        }
        String answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        String answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        String answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        System.out.println(underBar+answer1);
        System.out.println(underBar+answer2);
        System.out.println(underBar+answer3);
        makeString(depth+1,num);
        System.out.println(underBar+"라고 답변하였지.");
        return null;
    }
}

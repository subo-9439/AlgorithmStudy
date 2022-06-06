import java.util.HashSet;
import java.util.Set;

class subo {
    static StringBuilder sb = new StringBuilder();
    static int limit, maxCnt;
    static boolean[] visited;
    static int[] nums;
    static Set<Integer> set = new HashSet<>();
    
    
    public int solution(String numbers) {
        char[] charNums = numbers.toCharArray();

        nums = new int[charNums.length];            //총 숫자
        visited = new boolean[charNums.length];     //순열문제이기 떄문에 visited 체크.
        for (int i = 0; i < nums.length; i++) nums[i] = charNums[i] - '0';//숫자로 변환

        maxCnt = nums.length;                          // 최대 maxCnt 자리까지 만들어야 한다.
        for (int cnt = 1; cnt <= maxCnt; cnt++){//  1자리수부터 maxCnt자리수까지 순열 체크
            int[] temp = new int[cnt];            //자리수에 맞게 생성할 숫자를 만들 수 있도록 해주는 배열
            limit = cnt;                         // limit에 도달하면
            permutation(0,0,temp);

        }
        
        int answer = (int) set.stream().filter(v -> isPrime(v)).count();
        return answer;
    }

    public void permutation(int idx, int idxCnt,int[] temp){
        if (idxCnt == limit){   //배열의 요소가 자리수만큼 채워지면
            for (int i = 0; i < temp.length; i++) sb.append(temp[i]);   // temp의 요소로 숫자 만들기
            set.add(Integer.parseInt(sb.toString()));//만들 수 있는 모든 수 set에 저장
            sb.setLength(0);                            //초기화
        }else {
            for (int i = 0; i < nums.length; i++){
                if (visited[i]) continue;               //방문한적있으면 컨티뉴
                temp[idx] = nums[i];                    //temp 자리에 숫자 넣기
                visited[i] = true;                         
                permutation(idx+1,idxCnt+1 ,temp);
                visited[i] = false;                     //방문해제
            }
        }

    }
    public boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        if(num == 2 || num == 3) return true;
        for (int i= 2; i <= Math.sqrt(num); i++){
            if(num% i == 0) return false;
        }
        return true;
    }

}
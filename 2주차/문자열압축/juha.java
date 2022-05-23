class Solution {
    public int solution(String s) {
        int cnt = Integer.MAX_VALUE;
        char[] array = s.toCharArray();
        for(int i = 1; i<= array.length; i++){
            String tmp_s = "";
            int x_cnt = 1;
            String past_x = "";
            String present_x = "";
            for(int j = 0; j< array.length; j+=i){
                for(int k = j; k<j+i; k++){
                    if(k< array.length)
                        present_x += array[k];
                }
                if(j>0){
                    if(past_x.equals(present_x))
                        x_cnt++;
                    else{
                        if(x_cnt>1)
                            tmp_s += Integer.toString(x_cnt);
                        tmp_s+= past_x;
                        x_cnt = 1;
                    }
                }
                past_x = present_x;
                present_x = "";
            }
            if(x_cnt>1)
                tmp_s += Integer.toString(x_cnt);
            tmp_s+= past_x;

            cnt = Math.min(cnt, tmp_s.length());
        }
        return cnt;
    }
}
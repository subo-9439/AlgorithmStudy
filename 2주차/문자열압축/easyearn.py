def solution(s):
    length=len(s)  #문자열 길이
    result=[] #길이별로 자른 압축길이 저장
    
    if length==1: #문자열의 길이가 1인 경우
        return 1
    
    for i in range(1,length//2+1):  #2번반복까지만 확인하면 됨. (1개~ 전체 길이의 반 길이만큼 자른다) 
        cnt=1 #처음 자른 갯수부터 시작
        cnd="" #압축 후보
        target=s[:i] #비교할 문자열
        for j in range(i,length,i): #전체길이만큼 확인, i만큼 자르면서
            if target==s[j:j+i]: #다음 문자열이 target과 같으면
                cnt+=1
            else:
                if cnt!=1: #반복횟수+target->cnd
                    cnd+=(str(cnt)+target)
                else: #target->cnd
                    cnd+=target
                target=s[j:j+i] #target update
                cnt=1 #반복횟수 초기화
        #끝에 남은 문자열이 있을경우.(자르는 크기보다 적게 남을경우)
        if cnt!=1:
            cnd=cnd+str(cnt)+target
        else:
            cnd=cnd+target
        #cnd(i만큼 잘라서 압축한 결과)길이 result에 저장
        result.append(len(cnd))
        
    answer=min(result) #가장 작은 압축길이 return
    return answer
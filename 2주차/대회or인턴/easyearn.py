# 여학생 n명 / 남학생 m명 (2:1 팀)
# k명은 인턴쉽, (n+m-k)참여 가능
# 최대한 많은 팀 수 구하기 --> greedy / 구현으로 더 빨리 가능

n,m,k=map(int,input().split()) #입력

if n//2==m: #여학생:남학생=2:1
    K=k//3 if k%3==0 else k//3+1
    result=m-K
elif n//2>m: #팀을 만들때 여학생이 남학생보다 많을 경우
    if k<=n-m*2: #만약 잉여가 k보다 클 경우, 남학생 수 만큼만 팀을 짜면 됨
        result=m
    else:  #만약 잉여가 k보다 작을 경우, 
        k-=n-m*2 #k에서 잉여만큼 빼주고
        K=k//3 if k%3==0 else k//3+1 
        result=m-K #2:1이 맞춰졌을 경우와 똑같이 계산하면 됨
elif n//2<m: #팀을 만들때 남학생이 여학생보다 많을 경우 (윗 케이스와 동일하게 적용)
    if k<=m-n//2:
        result=n//2
    else:
        k-=m-n//2
        K=k//3 if k%3==0 else k//3+1
        result=n//2-K

print(result)
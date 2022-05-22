import sys

n,m=map(int,sys.stdin.readline().split()) #세로,가로 길이 입력

if n==1: #세로가 1일 경우, 시작점만 가능
    ans=1
elif n==2: #세로가 2일 경우, 짝수 y만 가능
    ans=min(4,(m+1)//2)
elif m<7: #세로가 3이상, 가로가 7이하일 경우. (1,2,3,4 움직임의 가로길이 총합: 6)
    ans=min(4,m) #최대 4번까지만 움직임 가능
else: #세로 3이상, 가로 7이상
    ans=m-7+5 #7일 때 5개칸 가능, 7초과는 자유롭게 가능.

print(ans)

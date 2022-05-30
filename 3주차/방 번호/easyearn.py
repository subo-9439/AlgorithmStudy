import sys

cnt=[0]*10 #0~9카드 개수 세기
room_num=str(sys.stdin.readline().strip())
for num in room_num: #숫자카드 count
    cnt[int(num)]+=1

cnt_special=(cnt[6]+cnt[9])//2 if (cnt[6]+cnt[9])%2==0 else (cnt[6]+cnt[9])//2+1 #6,9카드 개수 통합
cnt[6]=cnt_special
cnt[9]=cnt_special

print(max(cnt)) #가장 많이 필요한 카드의 개수를 기준으로 카드묶음 계산

import math
from itertools import permutations #조합 사용

def solution(numbers):
    answer = [] #조합한 수 중 소수인 수를 담는 list
    num_paper=[] #문자열로 들어온 숫자 종이를 나눠 담을 list ex) "17"->[1,7]
    for n in numbers: #문자열 -> 숫자list
        n=int(n)
        num_paper.append(n)
        if find_prime(n): #1의자리 숫자가 소수인 경우
                answer.append(n)

    for i in range(2,len(numbers)+1): #숫자 카드 n개중 i만큼 뽑아 나열할 경우(순열)
        case=list(permutations(num_paper,i)) #순열 사용
        for num in case: #순열한 결과를 하나씩 소수가 맞는지 확인
            num=setToint(num) #순열 결과 -> (1,4) 처럼 set으로 반환되므로, int로 바꾸는 함수 이용
            if find_prime(num): #소수일 경우
                answer.append(num)

    return len(list(set(answer))) #중복된 소수를 제외하고 총 개수 return

def setToint(nums): #set ->int
    string=[str(num)for num in nums]
    a_string="".join(string)
    integer=int(a_string)
    return integer

def find_prime(integer): #소수인 경우, true 리턴
    if integer<2:
        return False
    elif integer<=3: #2,3
        return True
    else:
        for i in range(2,int(math.sqrt(integer))+1): #소수인지 확인하기 위해 제곱근까지만 나눠서 확인.
            if integer%i==0:
                return False
        return True
        
print(solution("17")) #test
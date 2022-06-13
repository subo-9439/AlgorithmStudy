#최소 변경 회수를 구해야 하기 때문에, bfs사용.
from collections import deque

def solution(begin, target, words):
    answer = 0
    q=deque()
    q.append([begin,0])
    visited=[0 for i in range(len(words))]
    while q:
        word, cnt= q.popleft()
        if word==target:
            answer=cnt
            break
        for i in range(len(words)):
            tmp=0
            if not visited[i]:
                for j in range(len(word)):
                    if word[j]!=words[i][j]: #words 후보와 word가 몇개의 글자가 다른지 확인
                        tmp+=1
                if tmp==1: #한개만 다를 경우, q에 삽입.
                    q.append([words[i],cnt+1])
                    visited[i]=1
    return answer

#test
print(solution("hit","cog",["hot", "dot", "dog", "lot", "log", "cog"]))
print(solution("hit","cog",	["hot", "dot", "dog", "lot", "log"]))
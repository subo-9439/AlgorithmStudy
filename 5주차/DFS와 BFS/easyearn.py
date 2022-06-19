from collections import deque
import sys

#깊이우선탐색 함수
def dfs(graph,v,visited,result):
    visited[v]=True
    result.append(str(v))
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited,result)
    return result

#너비우선탐색 함수
def bfs(graph,start,visited,result):
    queue=deque([start])
    visited[start]=True

    while queue:
        v=queue.popleft()
        result.append(str(v)) #탐색 완료
        #해당 원소와 연결된 아직 방문하지 않은 요소들 queue에 저장
        for i in graph[v]:
            if not visited[i]:
                queue.append(i) 
                visited[i]=True
    return result

#데이터 입력
n,m,v=map(int,sys.stdin.readline().split())
graph=[[] for _ in range(0,n+1)]
for _ in range(m):
    s,e=map(int,sys.stdin.readline().split())
    graph[s].append(e)
    graph[e].append(s)

for i in range(n+1):
    graph[i].sort()

#dfs, bfs 실행
print(' '.join(dfs(graph,v,[False for _ in range(n+1)],[])))
print(' '.join(bfs(graph,v,[False for _  in range(n+1)],[])))


        

#의식의 흐름: 최단거리를 위해 주변을 탐색하는 방법인 bfs를 사용하는 것이 좋을 것 같다 판단.
from sys import stdin

#입력받기
n,m=map(int,input().split())
graph=[stdin.readline().rstrip() for _ in range(n)]
visited=[[False]*(m) for _ in range(n)]

#move -> left, down, up, right
dx=[0,1,-1,0] 
dy=[1,0,0,-1]

#bfs 함수
def bfs(start,graph,visited):
    x,y=start[0]-1,start[1]-1
    queue=[(x,y)]
    visited[x][y]=True

    while queue:
        x,y=queue.pop(0)
        if x==n-1 and y==m-1:
            return visited[x][y]
        
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m:
                if graph[nx][ny]=='1' and visited[nx][ny]==False:
                    visited[nx][ny]=visited[x][y]+1
                    queue.append((nx,ny))

print(bfs((1,1),graph,visited))
    
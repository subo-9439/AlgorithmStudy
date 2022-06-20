n = int(input())
num = int(input())
snail = [[0] * n for i in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
x, y, i = 0, 0, 0
square = n * n

while True:
    snail[x][y] = square
    nx = x + dx[i]
    ny = y + dy[i]

    if nx >= n or ny >= n or snail[nx][ny] != 0 or nx < 0 or ny < 0:
        i += 1
        if i == 4:
            i = 0
        continue

    x, y = nx, ny
    square -= 1
    if square == 1:
        break

snail[x][y] = 1

for i in range(n):
    for j in range(n):
        if snail[i][j] == num:
            num_x, num_y = i + 1, j + 1
    print(*snail[i])

print(num_x, num_y)
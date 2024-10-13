import sys
from collections import deque

read = sys.stdin.readline

M, N = map(int, read().rstrip().split())

visited = [[-2] * M for _ in range(N)]

start_point = []
answer = 0

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(N):
    row = list(map(int, read().rstrip().split()))
    for j, item in enumerate(row):
        if item == 1:
            start_point.append((i, j, 0))
        elif item == -1:
            visited[i][j] = -1


def dfs():
    q = deque(start_point)

    while q:
        x, y, count = q.popleft()

        if visited[x][y] == -2:
            visited[x][y] = count

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == -2:
                    q.append((nx, ny, count+1))


dfs()

for row in visited:
    if -2 in row:
        print(-1)
        exit()
    else:
        answer = max([*row, answer])

print(answer)
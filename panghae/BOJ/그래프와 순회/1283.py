import sys
from collections import deque

read = sys.stdin.readline

M, N, K = map(int, read().rstrip().split())

board = [[0 for _ in range(M)] for _ in range(N)]

visited = [[False for _ in range(M)] for _ in range(N)]

for _ in range(K):
    s_x, s_y, e_x, e_y = map(int, read().rstrip().split())

    for x in range(s_x, e_x):
        for y in range(s_y, e_y):
            board[x][y] = -1

answer = 0
sizes = []

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(N):
    for j in range(M):
        if board[i][j] == 0 and not visited[i][j]:
            q = deque()
            q.append([i, j])
            visited[i][j] = True
            block_count = 0
            while q:
                x, y = q.popleft()
                block_count += 1

                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and board[nx][ny] == 0:
                        visited[nx][ny] = True
                        q.append([nx, ny])
            answer += 1
            sizes.append(block_count)

print(answer)
print(*sorted(sizes))

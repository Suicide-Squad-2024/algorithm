import sys
from collections import deque

read = sys.stdin.readline

n, m = map(int, read().rstrip().split())

board = [list(map(int, read().rstrip().split())) for _ in range(n)]

count = 0
max_val = 0

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(n):
    for j in range(m):

        if board[i][j] == 1:
            q = deque()
            q.append((i, j))
            board[i][j] = 0
            cur_size = 0

            while q:
                x, y = q.popleft()
                cur_size += 1

                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 1:
                        q.append((nx, ny))
                        board[nx][ny] = 0
            count += 1
            max_val = max(max_val, cur_size)

print(count)
print(max_val)

import sys
from collections import deque

read = sys.stdin.readline

N = int(read().rstrip())

max_height = 0

board = []

for _ in range(N):
    row = list(map(int, read().rstrip().split()))
    max_height = max(*row, max_height)
    board.append(row)

max_area = 0

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(0, max_height + 1):
    visited = [[False] * N for _ in range(N)]
    result = 0

    for m in range(N):
        for n in range(N):
            if board[m][n] > i and not visited[m][n]:
                q = deque()
                q.append((m, n))
                visited[m][n] = True

                while q:
                    x, y = q.popleft()
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        if 0 <= nx < N and 0 <= ny < N and board[nx][ny] > i and not visited[nx][ny]:
                            visited[nx][ny] = True
                            q.append((nx, ny))
                result += 1

    max_area = max(result, max_area)

print(max_area)

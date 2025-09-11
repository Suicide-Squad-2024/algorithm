import sys
from collections import deque

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

board = [list(map(int, read().rstrip().split())) for _ in range(N)]

year = 0

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs(start_point, v):
    global board

    q = deque()
    q.append(start_point)

    v[start_point[0]][start_point[1]] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] != 0 and not v[nx][ny]:
                v[nx][ny] = True
                q.append((nx, ny))


def melt():
    global board

    new_board = [[0] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if board[i][j] != 0:
                melt_count = 0
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
                        melt_count += 1
                new_board[i][j] = max(board[i][j] - melt_count, 0)
    board = new_board


while True:
    piece = 0
    visited = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if board[i][j] != 0 and not visited[i][j]:
                bfs((i, j), visited)
                piece += 1

    if piece >= 2:
        break
    elif piece == 0:
        year = 0
        break

    melt()
    year += 1

print(year)

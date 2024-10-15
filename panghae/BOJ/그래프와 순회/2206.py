import sys
from collections import deque

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

board = [list(read().strip()) for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs():
    global board
    q = deque([(0, 0, 0, 0)])
    visited = [[[False, False] for _ in range(M)] for _ in range(N)]

    while q:
        x, y, count, wall_broke = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if x == N - 1 and y == M - 1:
                return count + 1

            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == '0' and not visited[nx][ny][wall_broke]:
                    visited[nx][ny][wall_broke] = True
                    q.append((nx, ny, count+1, wall_broke))
                elif board[nx][ny] == '1' and wall_broke == 0:
                    visited[nx][ny][1] = True
                    q.append((nx, ny, count + 1, 1))
    return -1


print(bfs())

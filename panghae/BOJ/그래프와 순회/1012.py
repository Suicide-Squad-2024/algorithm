import sys
from collections import deque

read = sys.stdin.readline

T = int(read().rstrip())

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs(x,y,board, visited):
    q = deque([(x,y)])

    while q:
        x, y = q.popleft()

        if not visited[x][y]:
            visited[x][y] = True

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and board[nx][ny] == 1:
                    q.append((nx, ny))


for _ in range(T):
    M, N, K = map(int, read().rstrip().split())
    baechu_map = [[0 for _ in range(M)] for _ in range(N)]
    visited_map = [[False] * M for _ in range(N)]
    count = 0

    for _ in range(K):
        X, Y = map(int, read().rstrip().split())
        baechu_map[Y][X] = 1

    for i in range(N):
        for j in range(M):
            if baechu_map[i][j] == 1 and not visited_map[i][j]:
                bfs(i, j, baechu_map, visited_map)
                count += 1

    print(count)
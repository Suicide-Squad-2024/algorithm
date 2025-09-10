import sys
from collections import deque

read = sys.stdin.readline

M, N, H = map(int, read().rstrip().split())

start_points = []

board = []

for i in range(H):
    floor = []
    for j in range(N):
        row = list(map(int, read().rstrip().split()))
        for index, k in enumerate(row):
            if k == 1:
                start_points.append((i, j, index, 0))
        floor.append(row)
    board.append(floor)

if len(start_points) == M * N * H:
    print(0)
else:
    q = deque()
    for point in start_points:
        q.append(point)

    dx = [0, -1, 0, 1, 0, 0]
    dy = [0, 0, 1, 0, -1, 0]
    dz = [1, 0, 0, 0, 0, -1]

    count = 0

    while q:
        z, x, y, day = q.popleft()

        count = max(count, day)

        for k in range(6):
            nx = x + dx[k]
            ny = y + dy[k]
            nz = z + dz[k]

            if 0 <= nx < N and 0 <= ny < M and 0 <= nz < H and board[nz][nx][ny] == 0:
                board[nz][nx][ny] = 1
                q.append((nz, nx, ny, day + 1))

    for h in range(H):
        for i in range(N):
            for j in range(M):
                if board[h][i][j] == 0:
                    print(-1)
                    exit()

    print(count)

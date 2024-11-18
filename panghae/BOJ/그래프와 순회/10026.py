import sys
from collections import deque

read = sys.stdin.readline

N = int(read().rstrip())

color_map = [list(read().rstrip()) for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

original_count = 0
count = 0
visited_original = [[False] * N for _ in range(N)]
visited = [[False] * N for _ in range(N)]


def bfs0(x, y, start_color):
    global original_count, color_map
    q = deque([(x, y)])
    visited_original[x][y] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and color_map[nx][ny] == start_color and not visited_original[nx][ny]:
                q.append((nx, ny))
                visited_original[nx][ny] = True

    original_count += 1


def bfs1(x, y, start_color):
    global count, color_map
    q = deque([(x, y)])
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if start_color != 'B' and color_map[nx][ny] != 'B':
                    visited[nx][ny] = True
                    q.append((nx, ny))
                elif start_color == 'B' and color_map[nx][ny] == 'B':
                    visited[nx][ny] = True
                    q.append((nx, ny))

    count += 1


for i in range(N):
    for j in range(N):
        if not visited_original[i][j]:
            bfs0(i, j, color_map[i][j])
        if not visited[i][j]:
            bfs1(i, j, color_map[i][j])

print(original_count, count)

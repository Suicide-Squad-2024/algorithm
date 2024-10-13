import sys
from collections import deque

read = sys.stdin.readline

N = int(read().rstrip())

square_map = [list(map(int, read().rstrip())) for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

count = 0
apt_count = []


def bfs(x, y):
    global count
    q = deque([(x, y)])
    apt_num = 0

    while q:
        x, y = q.popleft()
        if square_map[x][y] == 1:
            apt_num += 1
            square_map[x][y] = 0

            for i in range(4):
                new_x = x + dx[i]
                new_y = y + dy[i]
                if 0 <= new_x < N and 0 <= new_y < N and square_map[new_x][new_y] == 1:
                    q.append((new_x, new_y))

    count += 1
    apt_count.append(apt_num)


for i in range(N):
    for j in range(N):
        if square_map[i][j] == 1:
            bfs(i, j)

print(count)
for apt in sorted(apt_count):
    print(apt)